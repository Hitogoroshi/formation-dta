package fr.pizzeria.ihm;

import java.io.IOException;
import java.util.Optional;
import java.util.Scanner;

import fr.pizzeria.exception.SaisieNombreException;
import fr.pizzeria.model.AbstractPersonne;
import fr.pizzeria.model.Client;
import fr.pizzeria.model.Livreur;
import fr.pizzeria.model.Pizza;
import fr.pizzeria.service.Stockage;

public class IhmHelper {

	private Stockage<Pizza> stockagePizza;
	private Stockage<Client> stockageClient;
	private Stockage<Livreur> stockageLivreur;
	private Scanner scanner;

	public IhmHelper(Stockage<Pizza> stockage, Stockage<Client> stockageC, Stockage<Livreur> stockageL,
			Scanner scanner) {
		super();
		this.stockagePizza = stockage;
		this.scanner = scanner;
		this.stockageClient = stockageC;
		this.stockageLivreur = stockageL;
	}

	public int saisirEntier() throws SaisieNombreException {
		try {
			String saisie = scanner.next();
			return Integer.parseInt(saisie);
		} catch (NumberFormatException e) {
			throw new SaisieNombreException(e);
		}
	}

	public double saisirDouble() throws SaisieNombreException {
		try {
			String saisie = scanner.next();
			return Double.parseDouble(saisie);
		} catch (NumberFormatException e) {
			throw new SaisieNombreException(e);
		}
	}

	public Optional<? extends AbstractPersonne> findPersonne(String idRecherche) throws IOException {

		if (idRecherche.startsWith(Livreur.PREFIX_ID)) {
			return find(idRecherche, Livreur.PREFIX_ID, this.getStockageLivreur());

		} else if (idRecherche.startsWith(Client.PREFIX_ID)) {
			return find(idRecherche, Client.PREFIX_ID, this.getStockageClient());
		}
		return null;
	}

	private Optional<? extends AbstractPersonne> find(String idRecherche, String prefixId,
			Stockage<? extends AbstractPersonne> stockage) throws IOException {

		return stockage.findAll().stream().filter(t -> t.getId() == Integer.valueOf(idRecherche.replace(prefixId, "")))
				.findFirst();

		/*
		 * Vieux For : for (AbstractPersonne personne : stockage.findAll()) { if
		 * (personne.getId() == idInt) { return personne; } }
		 */
	}

	public Stockage<Pizza> getStockagePizza() {
		return stockagePizza;
	}

	public Scanner getScanner() {
		return scanner;
	}

	public Stockage<Client> getStockageClient() {
		// TODO Auto-generated method stub
		return stockageClient;
	}

	public Stockage<Livreur> getStockageLivreur() {
		// TODO Auto-generated method stub
		return stockageLivreur;
	}

}
