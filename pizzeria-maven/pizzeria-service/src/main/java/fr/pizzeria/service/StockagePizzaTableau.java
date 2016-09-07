package fr.pizzeria.service;

import java.util.Collection;
import java.util.Map;
import java.util.TreeMap;

import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

public class StockagePizzaTableau implements Stockage<Pizza> {

	public Map<String, Pizza> pizzas = new TreeMap<>();

	public StockagePizzaTableau() {
		this.pizzas.put("PEP", new Pizza("PEP", "P�p�roni", 12.50, CategoriePizza.VIANDE));
		this.pizzas.put("MAR", new Pizza("MAR", "Margherita", 14.00, CategoriePizza.SANS_VIANDE));
		this.pizzas.put("REI", new Pizza("REI", "La Reine", 11.50, CategoriePizza.VIANDE));
		this.pizzas.put("FRO", new Pizza("FRO", "La 4 fromages", 12.00, CategoriePizza.SANS_VIANDE));
		this.pizzas.put("CAN", new Pizza("CAN", "La cannibale", 12.50, CategoriePizza.VIANDE));
		this.pizzas.put("SAV", new Pizza("SAV", "La savoyarde", 13.00, CategoriePizza.SANS_VIANDE));
		this.pizzas.put("ORI", new Pizza("ORI", "L'orientale", 13.50, CategoriePizza.VIANDE));
		this.pizzas.put("IND", new Pizza("IND", "L'indienne", 14.00, CategoriePizza.VIANDE));

	}

	@Override
	public Collection<Pizza> findAll() {
		return pizzas.values();
	}

	@Override
	public void save(Pizza newPizza) {
		this.pizzas.put(newPizza.getCode(), newPizza);
	}

	@Override
	public void update(Pizza editPizza, String ancienCode) {
		this.pizzas.remove(ancienCode);
		this.pizzas.put(editPizza.getCode(), editPizza);

	}

	@Override
	public void delete(String ancienCode) {
		this.pizzas.remove(ancienCode);
	}

}
