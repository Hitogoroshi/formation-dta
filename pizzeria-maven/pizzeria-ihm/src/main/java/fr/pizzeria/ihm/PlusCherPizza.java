package fr.pizzeria.ihm;

import java.io.IOException;
import java.util.Comparator;
import java.util.stream.Collectors;

import fr.pizzeria.model.Pizza;

public class PlusCherPizza extends Action {

	public PlusCherPizza(IhmHelper helper) {
		super("Afficher la pizza la plus cher", helper);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void execute() throws IOException {

		helper.getStockagePizza().findAll().stream().collect(Collectors.maxBy(Comparator.comparing(Pizza::getPrix)))
				.ifPresent(pizza -> System.out.println(pizza.getCode() + " " + pizza.getNom() + " " + pizza.getPrix()));

	}

}
