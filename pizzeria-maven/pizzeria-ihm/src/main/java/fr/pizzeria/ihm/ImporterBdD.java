package fr.pizzeria.ihm;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.commons.collections4.ListUtils;

import fr.pizzeria.exception.ServiceException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

public class ImporterBdD extends Action {

	public ImporterBdD(IhmHelper helper) {
		super("BdD	Importer les donnees", helper);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void execute() throws IOException {

		// Ecriture dans le fichier data/pizza/test.txt de 2 lignes
		try (Stream<Path> list = Files.list(Paths.get("data", "Pizza"));) {

			List<Pizza> listeTotalePizzas = list.map(cheminFichier -> {

				Pizza p = new Pizza();
				try {
					Optional<String> opt = Files.lines(cheminFichier, Charset.forName("Cp1252")).findFirst();
					String line = opt.get();

					// tab[0], tab[1]
					String[] tab = line.split(";");
					p.setCode(cheminFichier.toFile().getName().replaceAll(".txt", ""));
					p.setNom(tab[0]);
					p.setPrix(Double.valueOf(tab[1]));
					p.setCategorie(CategoriePizza.valueOf(tab[2]));

				} catch (IOException e) {
					e.printStackTrace();
				}

				return p;
			}).collect(Collectors.toList());

			List<List<Pizza>> listeDecoupPizzas = ListUtils.partition(listeTotalePizzas, 3);

			try (Connection connection = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/pizzeria?useSSL=false", "root", "");) {
				listeDecoupPizzas.forEach(listPizzas -> {

					try {
						connection.setAutoCommit(false);
					} catch (SQLException e1) {
						throw new ServiceException(e1);
					}

					listPizzas.forEach(pizza -> {

						try (PreparedStatement savePizza = connection.prepareStatement(
								"INSERT INTO PIZZA(reference, libelle, prix, categorie, url_image) VALUES( ?, ?, ?, ?, ?)");) {
							savePizza.setString(1, pizza.getCode());
							savePizza.setString(2, pizza.getNom());
							savePizza.setDouble(3, pizza.getPrix());
							savePizza.setString(4, pizza.getCategorie().name());
							savePizza.setString(5, pizza.getNom() + ".jpg");
							savePizza.executeUpdate();
						} catch (SQLException e) {
							try {
								connection.rollback();
							} catch (SQLException e1) {
								throw new ServiceException(e);
							}
							throw new ServiceException(e);

						}

					});

					try {
						connection.commit();
					} catch (SQLException e) {
						throw new ServiceException(e);
					}
				});
			} catch (SQLException e) {
				throw new ServiceException(e);
			}

		}
	}

}
