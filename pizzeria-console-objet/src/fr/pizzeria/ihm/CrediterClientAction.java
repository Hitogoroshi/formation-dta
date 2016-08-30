package fr.pizzeria.ihm;

import java.util.ArrayList;
import java.util.List;

import fr.pizzeria.exception.CreditException;
import fr.pizzeria.model.AbstractPersonne;
import fr.pizzeria.model.CompteStat;

public class CrediterClientAction extends Action {

	public CrediterClientAction(IhmHelper helper) {
		// TODO Auto-generated constructor stub
		super("Crediter un client", helper);
	}

	@Override
	public void execute() {

		List<CompteStat> stats = new ArrayList<>();
		stats.addAll(helper.getStockageLivreur().findAll());
		stats.addAll(helper.getStockageClient().findAll());

		for (CompteStat personneEnCours : stats) {
			System.out.println(personneEnCours.toString());
		}

		System.out.println("choisir l'id de la personne a crediter");
		String id = helper.getScanner().next();
		AbstractPersonne personne = helper.findPersonne(id);
		System.out.println("Entrez le montant à crediter");
		double montant = helper.getScanner().nextInt();

		if (personne == null) {
			System.out.println("Individu non trouver\n");
		} else {
			try {
				personne.crediterCompte(montant);
				System.out.println("Credit realiser avec succes\n");
			} catch (CreditException e) {
				System.out.println(e.getMessage());
			}
		}

		/*
		 * Collection<Client> clients =
		 * this.helper.getStockageClient().findAll();
		 * System.out.println("Choisir l id du client à crediter"); Integer id =
		 * helper.getScanner().nextInt(); Client clientTrouve = null;
		 * 
		 * for (Client clientEnCours : clients) { if (clientEnCours.getId() ==
		 * id) { clientTrouve = clientEnCours; } }
		 * 
		 * if (clientTrouve == null) {
		 * System.out.println("Client non trouver veuillez recommencer"); } else
		 * { System.out.println("Choisir le montant à crediter"); double montant
		 * = helper.getScanner().nextDouble(); try {
		 * clientTrouve.crediterCompte(montant);
		 * System.out.println("compte crediter avec succes \n"); } catch
		 * (CreditException e) { System.out.println(e.getMessage()); } }
		 */

	}

}
