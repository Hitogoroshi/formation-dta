package fr.pizzeria.ihm;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

import org.reflections.Reflections;

import fr.pizzeria.exception.SaisieNombreException;

public class Menu {

	// Variable choixsortir qui est fixer ici affin que en modifiant ici ça
	// modifie partout
	private static final int CHOIX_SORTIR = 99;
	// Creation de la map qui sera utiliser pour mettre des actions
	private Map<Integer, Action> actions = new HashMap<>();
	private IhmHelper ihmHelper;

	// Map des actions que le menu peut executer
	public Menu(IhmHelper helper) {
		/*
		 * this.actions.put(1, new ListerPizzaAction(helper));
		 * this.actions.put(2, new GroupCatePizza(helper)); this.actions.put(3,
		 * new PlusCherPizza(helper)); this.actions.put(4, new
		 * AjouterPizzaAction(helper)); this.actions.put(5, new
		 * ModifierPizzaAction(helper)); this.actions.put(6, new
		 * SupprimerPizzaAction(helper)); this.actions.put(7, new
		 * ListerClient(helper)); this.actions.put(8, new
		 * AjouterClientAction(helper)); this.actions.put(9, new
		 * ListerLivreur(helper)); this.actions.put(10, new
		 * CrediterClientAction(helper)); this.actions.put(11, new
		 * DebiterClientAction(helper)); this.actions.put(12, new
		 * FaireVirementAction(helper)); this.actions.put(13, new
		 * AfficheStats(helper));
		 */
		// Reflection
		Reflections reflection = new Reflections();
		Set<Class<?>> annotated = reflection.getTypesAnnotatedWith(AnnotationAction.class);
		// permet de manipuler des entier si j'ai plusieurs processus qui
		// arrivent en meme temps
		// je veux incrementer et je suis sure que cela vas marcher
		AtomicInteger yournotkillme = new AtomicInteger(0);

		annotated.stream().forEach(uneClasse -> {
			try {
				Constructor<?> constructor = uneClasse.getConstructor(IhmHelper.class);
				Object action = constructor.newInstance(helper);
				this.actions.put(yournotkillme.incrementAndGet(), (Action) action);
			} catch (Exception e) {

			}
		});

		this.ihmHelper = helper;
	}

	// Methode de lancement du Menu on relance le menu tant que une action
	// correcte n'a pas ete donnée ou que l'on a pas quitter
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
			Action ActionEnCours = valeur;
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

				Action LaBonneAction = actions.get(choix);
				LaBonneAction.execute();

			}
		} catch (SaisieNombreException e) {
			System.out.println(e.getMessage());
		}

		return choix == CHOIX_SORTIR;
	}

}
