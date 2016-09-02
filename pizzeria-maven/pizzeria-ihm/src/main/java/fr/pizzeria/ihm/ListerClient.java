package fr.pizzeria.ihm;

import java.io.IOException;
import java.util.Collection;

import fr.pizzeria.model.Client;

public class ListerClient extends Action {

	public ListerClient(IhmHelper helper) {
		super("Lister les clients", helper);
		// TODO Auto-generated constructor stub
	}

	public void execute() throws IOException {
		System.out.println("**** Liste de Clients ****");
		Collection<Client> clients = this.helper.getStockageClient().findAll();

		// Java 8
		clients.forEach(System.out::println);

		/*
		 * Java7 for (Client clientEnCours : clients) {
		 * System.out.println(clientEnCours.toString()); }
		 */
		System.out.println("\n");
	}
}
