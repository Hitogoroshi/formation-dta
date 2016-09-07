package fr.pizzeria.ihm;

import java.io.IOException;
import java.util.Arrays;

import fr.pizzeria.exception.SaisieNombreException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

public class ModifierPizzaAction extends Action {

	public ModifierPizzaAction(IhmHelper helper) {
		super("Modifier une pizza", helper);
	}

	@Override
	public void execute() throws IOException {

		System.out.println("Vous voulez modifier une pizza veuillez choisir laquelle (Code)");
		String ancienCode = helper.getScanner().next();
		System.out.println("Veuillez saisir le nouveau code");
		String code = helper.getScanner().next();
		System.out.println("Veuillez saisir le nouveau nom de la pizza");
		String nom = helper.getScanner().next();
		System.out.println("Veuillez saisir le nouveau prix de la pizza");
		try {
			double prix = helper.saisirDouble();
			System.out.println("Categorie disponibles\n");
			Arrays.asList(CategoriePizza.values()).forEach(System.out::println);
			System.out.println("Veuillez saisir la nouvelle categorie la pizza en majuscule");
			CategoriePizza categorie = CategoriePizza.valueOf(helper.getScanner().next());
			// creation de la nouvelle pizza
			Pizza nouvellePizza = new Pizza(code, nom, prix, categorie);
			helper.getStockagePizza().update(nouvellePizza, ancienCode);

			System.out.println("Pizza modifier avec succes" + "\n");
		} catch (SaisieNombreException e) {
			System.out.println(e.getMessage());
		} catch (IllegalArgumentException e) {
			System.out.println("Vous devrez rentrer un categorie deja exsistante");
		}

	}

}
