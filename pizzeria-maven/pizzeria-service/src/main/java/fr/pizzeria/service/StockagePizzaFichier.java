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
import java.util.stream.Stream;

import fr.pizzeria.exception.ServiceException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

public class StockagePizzaFichier implements Stockage<Pizza, String> {

	@Override
	public Collection<Pizza> findAll() {

		// try avec un arguement il vas fermer le fichier a la fin list.close();
		try (Stream<Path> list = Files.list(Paths.get("data", "Pizza"))) {
			// parcourir le r�pertoire data/pizza

			return list.map(cheminFichier -> {

				Pizza p = new Pizza();
				try {
					Optional<String> opt = Files.lines(cheminFichier).findFirst();
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
			// Cette exception est lev�e si l'objet FileInputStream ne trouve
			// aucun fichier
			System.out.println("Fichier non trouver");
		} catch (IOException e) {
			// Celle-ci se produit lors d'une erreur d'�criture ou de lecture
			throw new ServiceException(e);

		}

		return null;
	}

	@Override
	public void save(Pizza newPizza) {

		// Cr�ation chemin d'un fichier data/pizza/test.txt
		Path cheminFichier = Paths.get("data", "Pizza", newPizza.getCode() + ".txt");

		// Ecriture dans le fichier data/pizza/test.txt de 2 lignes
		try {

			// Cr�ation d'un nouveau fichier
			Files.createFile(cheminFichier);
			Files.write(cheminFichier,
					Arrays.asList(newPizza.getNom() + ";" + newPizza.getPrix() + ";" + newPizza.getCategorie().name()));
		} catch (IOException e) {
			throw new ServiceException(e);
		}

	}

	@Override
	public void update(Pizza editPizza, String code) {
		// Modifier un fichier pizza
		// Cr�ation chemin d'un fichier data/pizza/test.txt
		Path ancienFichier = Paths.get("data", "pizza", code + ".txt");
		Path nouveauFichier = Paths.get("data", "pizza", editPizza.getCode() + ".txt");

		// Ecriture dans le fichier data/pizza/test.txt de 2 lignes
		try {
			Files.write(ancienFichier, Arrays
					.asList(editPizza.getNom() + ";" + editPizza.getPrix() + ";" + editPizza.getCategorie().name()));
		} catch (IOException e) {
			throw new ServiceException(e);
		}

		// Renommer le fichier
		ancienFichier.toFile().renameTo(nouveauFichier.toFile());

	}

	@Override
	public void delete(String ancienCode) {
		try {
			// Supprimer un fichier pizza
			Files.deleteIfExists(Paths.get("data", "Pizza", ancienCode + ".txt"));
		} catch (IOException e) {
			throw new ServiceException(e);
		}

	}

}