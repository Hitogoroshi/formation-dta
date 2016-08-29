package fr.pizzeria.ihm;

import java.util.Collection;

import fr.pizzeria.exception.DebitException;
import fr.pizzeria.model.Client;

public class DebiterClientAction extends Action {

	public DebiterClientAction(IhmHelper helper) {
		// TODO Auto-generated constructor stub
		super("Debiter un client", helper);
	}

	@Override
	public void execute() {
		Collection<Client> clients = this.helper.getStockageClient().findAll();
		System.out.println("Choisir l id du client à debiter");
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
			System.out.println("Choisir le montant à debiter");
			double montant = helper.getScanner().nextDouble();
			try {
				clientTrouve.debiterCompte(montant);
				System.out.println("compte debiter avec succes \n");
			} catch (DebitException e) {
				System.out.println(e.getMessage());
			}
		}

	}

}
