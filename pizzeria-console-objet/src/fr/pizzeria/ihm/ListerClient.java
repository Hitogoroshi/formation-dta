package fr.pizzeria.ihm;

import java.util.Collection;

import fr.pizzeria.model.Client;

public class ListerClient extends Action {

	public ListerClient(IhmHelper helper) {
		super("lister les clients", helper);
		// TODO Auto-generated constructor stub
	}

	public void execute() {
		System.out.println("**** Liste de Clients ****");
		Collection<Client> clients = this.helper.getStockageClient().findAll();
		for (Client clientEnCours : clients) {
			System.out.println(clientEnCours.toString());
		}
		System.out.println("\n");
	}
}
