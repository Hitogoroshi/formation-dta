package fr.pizzeria.ihm;

import java.util.Scanner;

import fr.pizzeria.exception.SaisieEntierException;
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

	public int saisirEntier() throws SaisieEntierException {
		try {
			String saisie = scanner.next();
			return Integer.parseInt(saisie);
		} catch (NumberFormatException e) {
			throw new SaisieEntierException(e);
		}
	}

	public AbstractPersonne findPersonne(String idRecherche) {

		if (idRecherche.startsWith(Livreur.PREFIX_ID)) {
			return find(idRecherche, Livreur.PREFIX_ID, this.getStockageLivreur());

		} else if (idRecherche.startsWith(Client.PREFIX_ID)) {
			return find(idRecherche, Client.PREFIX_ID, this.getStockageClient());
		}
		return null;
	}

	private AbstractPersonne find(String idRecherche, String prefixId, Stockage<? extends AbstractPersonne> stockage) {
		String id = idRecherche.replace(prefixId, "");
		// "1223" -> 1223
		Integer idInt = Integer.valueOf(id);
		for (AbstractPersonne personne : stockage.findAll()) {
			if (personne.getId() == idInt) {
				return personne;
			}
		}
		return null;
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
