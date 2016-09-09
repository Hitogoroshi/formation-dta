package fr.pizzeria.client;

import fr.pizzeria.model.Client;

public class Sinscrire extends ActionClient {

	public Sinscrire(IhmHelperClient helper) {
		super("S'inscrire", helper);

	}

	@Override
	public void execute() {
		System.out.println("Vous voulez etre enregistrer en tant que client");
		System.out.println("Veuillez saisir votre nom");
		String nom = helper.getScanner().next();
		System.out.println("Veuillez saisir votre prenom");
		String prenom = helper.getScanner().next();
		double solde = 0;
		Integer id = 0;
		System.out.println("Veuillez saisir votre email");
		String login = helper.getScanner().next();
		System.out.println("Veuillez saisir votre mot de passe");
		String motDePasse = helper.getScanner().next();
		// creation du nouveau Client
		Client nouveauClient = new Client(id, nom, prenom, solde, login, motDePasse);
		helper.getStockageClient().save(nouveauClient);

		System.out.println("Compte cree avec succes" + "\n");

	}

}
