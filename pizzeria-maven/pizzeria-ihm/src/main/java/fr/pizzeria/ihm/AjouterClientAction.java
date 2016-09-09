package fr.pizzeria.ihm;

import java.io.IOException;

import fr.pizzeria.model.Client;

@AnnotationAction
public class AjouterClientAction extends Action {

	public AjouterClientAction(IhmHelper helper) {
		// TODO Auto-generated constructor stub
		super("Ajouter un client", helper);
	}

	public void execute() throws IOException {

		// recuperation de la saisie

		System.out.println("Vous voulez ajoutez un client");
		System.out.println("Veuillez saisir le nom du client");
		String nom = helper.getScanner().next();
		System.out.println("Veuillez saisir le prenom du client");
		String prenom = helper.getScanner().next();
		double solde = 0;
		Integer id = 0;
		// creation du nouveau Client
		Client nouveauClient = new Client(id, nom, prenom, solde);
		helper.getStockageClient().save(nouveauClient);

		System.out.println("Client ajouter avec succes" + "\n");
	}

}
