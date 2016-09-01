package fr.pizzeria.ihm;

import java.io.IOException;

public class SupprimerPizzaAction extends Action {

	public SupprimerPizzaAction(IhmHelper helper) {
		super("Supprimer une pizza", helper);
	}

	@Override
	public void execute() throws IOException {
		System.out.println("Vous voulez supprimez une pizza veuillez choisir laquelle (Code)");
		String ancienCode = helper.getScanner().next();
		helper.getStockagePizza().delete(ancienCode);

		System.out.println("Pizza supprimer avec succes \n");

	}

}
