package fr.pizzeria.ihm;

import java.io.IOException;
import java.util.stream.Collectors;

import fr.pizzeria.model.Pizza;

public class GroupCatePizza extends Action {

	public GroupCatePizza(IhmHelper helper) {
		super("Grouper la liste de pizza par categorie", helper);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void execute() throws IOException {
		System.out.println("**** Liste de Pizzas Classé ****");
		helper.getStockagePizza().findAll().stream().collect(Collectors.groupingBy(Pizza::getCategorie))
				.forEach((cle, valeur) -> {
					System.out.println(cle);
					System.out.println("----------");
					valeur.forEach(pizza -> System.out
							.println(pizza.getCode() + " " + pizza.getNom() + " " + pizza.getPrix()));
					System.out.println("\n");
				});

	}

}
