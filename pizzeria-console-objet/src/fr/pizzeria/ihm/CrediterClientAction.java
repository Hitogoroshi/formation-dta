package fr.pizzeria.ihm;

import java.util.Collection;

import fr.pizzeria.exception.CreditException;
import fr.pizzeria.model.Client;

public class CrediterClientAction extends Action {

	public CrediterClientAction(IhmHelper helper) {
		// TODO Auto-generated constructor stub
		super("Crediter un client", helper);
	}

	@Override
	public void execute() {
		Collection<Client> clients = this.helper.getStockageClient().findAll();
		System.out.println("Choisir l id du client à crediter");
		Integer id = helper.getScanner().nextInt();
		Client clientTrouve = null;

		for (Client clientEnCours : clients) {
			if (clientEnCours.getId() == id) {
				clientTrouve = clientEnCours;
			}
		}

		if (clientTrouve == null) {
			System.out.println("Client non trouver veuillez recommencer");
		} else {
			System.out.println("Choisir le montant à crediter");
			double montant = helper.getScanner().nextDouble();
			try {
				clientTrouve.crediterCompte(montant);
				System.out.println("compte crediter avec succes \n");
			} catch (CreditException e) {
				System.out.println(e.getMessage());
			}
		}

	}

}
