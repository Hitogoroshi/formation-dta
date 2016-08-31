package fr.pizzeria.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

import fr.pizzeria.model.Pizza;

public class StockagePizzaFichier implements Stockage<Pizza> {

	@Override
	public Collection<Pizza> findAll() throws IOException {

		try {
			// Création chemin d'un fichier data/pizza/test.txt
			// Path cheminFichier = Paths.get("data", "pizza", "test.txt");

			// parcourir le répertoire data/pizza
			return Files.list(Paths.get("data", "Pizza")).map(cheminFichier -> {

				Pizza p = new Pizza();
				try {
					Optional<String> opt = Files.lines(cheminFichier).findFirst();
					String line = opt.get();

					// tab[0], tab[1]
					String[] tab = line.split(";");
					p.setNom(tab[0]);
					p.setPrix(tab[1]);
					p.setCategorie(tab[2]);

				} catch (IOException e) {
					e.printStackTrace();
				}

				return p;
			}).collect(Collectors.toList());

			// Parcourir les lignes d'un fichier
			// Files.lines(cheminFichier).forEach(System.out::println);

		} catch (NoSuchFileException e) {
			// Cette exception est levée si l'objet FileInputStream ne trouve
			// aucun fichier
			System.out.println("Fichier non trouver");
		} catch (IOException e) {
			// Celle-ci se produit lors d'une erreur d'écriture ou de lecture
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public void save(Pizza newPizza) throws IOException {

		// Création chemin d'un fichier data/pizza/test.txt
		Path cheminFichier = Paths.get("data", "Pizza", newPizza.getCode() + ".txt");

		// Création d'un nouveau fichier
		Files.createFile(cheminFichier);

		// Ecriture dans le fichier data/pizza/test.txt de 2 lignes
		Files.write(cheminFichier,
				Arrays.asList(newPizza.getNom() + ";" + newPizza.getPrix() + ";" + newPizza.getCategorie()));

	}

	@Override
	public void update(Pizza editPizza, String code) {
		// Modifier un fichier pizza

	}

	@Override
	public void delete(String ancienCode) {
		// Supprimer un fichier pizza

	}

}
