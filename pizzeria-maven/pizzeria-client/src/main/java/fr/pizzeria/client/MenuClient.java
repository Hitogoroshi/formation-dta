package fr.pizzeria.client;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import fr.pizzeria.exception.SaisieNombreException;
import fr.pizzeria.exception.ServiceException;

public class MenuClient {

	// Variable choixsortir qui est fixer ici affin que en modifiant ici
	// modifie partout
	private static final int CHOIX_SORTIR = 99;
	// Creation de la map qui sera utiliser pour mettre des actions
	private Map<Integer, ActionClient> actions = new HashMap<>();
	private IhmHelperClient ihmHelper;

	// Map des actions que le menu peut executer
	public MenuClient(IhmHelperClient helper) {

		this.actions.put(1, new Sinscrire(helper));
		this.actions.put(2, new SeConnecter(helper));

		this.ihmHelper = helper;
	}

	// Methode de lancement du Menu on relance le menu tant que une action
	// correcte n'a pas ete donnee ou que l'on a pas quitter
	public void start() throws IOException {
		boolean result = false;
		do {
			affichageM();
			result = choisir();
		} while (!result);
	}

	// Methode d'affichage du menu a l'aide d'une boucle Java 8
	public void affichageM() {
		System.out.println("***** Pizzeria Administration *****");

		actions.forEach((numero, valeur) -> {
			ActionClient ActionEnCours = valeur;
			String libelleAction = ActionEnCours.getLibelle();
			System.out.println(numero + " " + libelleAction);
		});

		System.out.println(CHOIX_SORTIR + " Quitter" + "\n");
	}

	public boolean choisir() throws IOException {
		System.out.println("Veuillez choisir une option");
		int choix = 0;
		try {
			// Instructions susceptibles de provoquer des erreurs;

			choix = ihmHelper.saisirEntier();
			if (!actions.containsKey(choix)) {
				if (choix != CHOIX_SORTIR) {
					System.out.println("Erreur de saisie, veuillez recommencer!" + "\n");
				}
			} else {

				ActionClient LaBonneAction = actions.get(choix);
				LaBonneAction.execute();

			}
		} catch (SaisieNombreException e) {
			System.out.println(e.getMessage());
		} catch (ServiceException e) {
			System.err.println(e.getMessage());
		}

		return choix == CHOIX_SORTIR;
	}

}
