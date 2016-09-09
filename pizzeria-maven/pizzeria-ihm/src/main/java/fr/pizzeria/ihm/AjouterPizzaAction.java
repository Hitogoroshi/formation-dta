package fr.pizzeria.ihm;

import java.io.IOException;
import java.util.Arrays;

import fr.pizzeria.exception.SaisieNombreException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

@AnnotationAction
public class AjouterPizzaAction extends Action {

	public AjouterPizzaAction(IhmHelper helper) {
		super("Ajouter une pizza", helper);
	}

	@Override
	public void execute() throws IOException {

		// recuperation de la saisie
		System.out.println("Vous voulez ajoutez une pizza");
		System.out.println("Veuillez saisir le code");
		String code = helper.getScanner().next();
		System.out.println("Veuillez saisir le nom de la pizza sans espace");
		String nom = helper.getScanner().next();
		System.out.println("Veuillez saisir le prix de la pizza");
		try {
			double prix = helper.saisirDouble();
			System.out.println("Categorie disponibles\n");
			Arrays.asList(CategoriePizza.values()).forEach(System.out::println);
			System.out.println("Veuillez saisir la categorie la pizza");
			CategoriePizza categorie = CategoriePizza.valueOf(helper.getScanner().next());
			// creation de la nouvelle pizza
			Pizza nouvellePizza = new Pizza(code, nom, prix, categorie);
			helper.getStockagePizza().save(nouvellePizza);

			System.out.println("Pizza ajouter avec succes" + "\n");
		} catch (SaisieNombreException e) {
			System.out.println(e.getMessage());
		} catch (IllegalArgumentException e) {
			System.out.println("Vous devrez rentrer un categorie deja exsistante");
		}

	}

}
