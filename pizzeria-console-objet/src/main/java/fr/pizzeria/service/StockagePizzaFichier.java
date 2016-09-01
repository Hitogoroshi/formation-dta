package fr.pizzeria.service;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.AccessDeniedException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

public class StockagePizzaFichier implements Stockage<Pizza> {

	@Override
	public Collection<Pizza> findAll() throws IOException {

		// try avec un arguement il vas fermer le fichier a la fin list.close();
		try (Stream<Path> list = Files.list(Paths.get("data", "Pizza"))) {
			// parcourir le répertoire data/pizza

			return list.map(cheminFichier -> {

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
				Arrays.asList(newPizza.getNom() + ";" + newPizza.getPrix() + ";" + newPizza.getCategorie().name()));

	}

	@Override
	public void update(Pizza editPizza, String code) throws IOException {
		// Modifier un fichier pizza
		// Création chemin d'un fichier data/pizza/test.txt
		Path cheminFichier = Paths.get("data", "pizza", code + ".txt");

		// Ecriture dans le fichier data/pizza/test.txt de 2 lignes
		Files.write(cheminFichier,
				Arrays.asList(editPizza.getNom() + ";" + editPizza.getPrix() + ";" + editPizza.getCategorie()));

		// Renommer le fichier
		// (code + ".txt").renameTo.toPath(editPizza.getCode() + ".txt");

	}

	@Override
	public void delete(String ancienCode) throws IOException {
		try {
			// Supprimer un fichier pizza
			Files.deleteIfExists(Paths.get("data", "Pizza", ancienCode + ".txt"));
		} catch (AccessDeniedException e) {
			e.printStackTrace();
		}

	}

}