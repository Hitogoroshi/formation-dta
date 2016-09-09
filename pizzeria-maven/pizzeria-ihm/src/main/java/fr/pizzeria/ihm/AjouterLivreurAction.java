package fr.pizzeria.ihm;

import java.io.IOException;

import fr.pizzeria.model.Livreur;

public class AjouterLivreurAction extends Action {

	public AjouterLivreurAction(IhmHelper helper) {
		super("Ajouter un nouveau livreur", helper);

	}

	@Override
	public void execute() throws IOException {

		// recuperation de la saisie

		System.out.println("Vous voulez ajoutez un client");
		System.out.println("Veuillez saisir le nom du client");
		String nom = helper.getScanner().next();
		System.out.println("Veuillez saisir le prenom du client");
		String prenom = helper.getScanner().next();
		double solde = 0;
		Integer id = 0;
		System.out.println("Veuillez saisir le login");
		String login = helper.getScanner().next();
		System.out.println("Veuillez saisir le mot de passe");
		String motDePasse = helper.getScanner().next();
		System.out.println("Veuillez saisir le montant du decouvert autoriser");
		double MontantDecouvertAutoriser = helper.getScanner().nextDouble();
		// creation du nouveau Livreur
		Livreur nouveauLivreur = new Livreur(id, nom, prenom, solde, login, motDePasse, MontantDecouvertAutoriser);
		helper.getStockageLivreur().save(nouveauLivreur);

		System.out.println("Livreur ajouter avec succes" + "\n");
	}

}
