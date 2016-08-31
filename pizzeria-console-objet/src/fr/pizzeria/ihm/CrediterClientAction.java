package fr.pizzeria.ihm;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import fr.pizzeria.exception.CreditException;
import fr.pizzeria.exception.SaisieNombreException;
import fr.pizzeria.model.AbstractPersonne;
import fr.pizzeria.model.CompteStat;

public class CrediterClientAction extends Action {

	public CrediterClientAction(IhmHelper helper) {
		super("Crediter un client", helper);
	}

	@Override
	public void execute() throws IOException {

		List<CompteStat> stats = new ArrayList<>();
		stats.addAll(helper.getStockageLivreur().findAll());
		stats.addAll(helper.getStockageClient().findAll());

		stats.forEach(System.out::println);

		System.out.println("choisir l'id de la personne a crediter");
		String id = helper.getScanner().next();
		Optional<? extends AbstractPersonne> personne = helper.findPersonne(id);
		System.out.println("Entrez le montant à crediter");
		try {
			double montant = helper.saisirDouble();

			if (personne.isPresent()) {
				System.out.println("Individu non trouver\n");
			} else {
				personne.get().crediterCompte(montant);
				System.out.println("Credit realiser avec succes\n");
			}
		} catch (CreditException e) {
			System.out.println(e.getMessage());
		} catch (SaisieNombreException e) {
			System.out.println(e.getMessage());
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
