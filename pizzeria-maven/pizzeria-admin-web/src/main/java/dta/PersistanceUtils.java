package dta;

import fr.pizzeria.model.Pizza;
import fr.pizzeria.service.Stockage;
import fr.pizzeria.service.StockagePizzaJpa;

public class PersistanceUtils {

	private static PersistanceUtils instanceUnique = new PersistanceUtils();
	private Stockage<Pizza, String> stockagePizza = new StockagePizzaJpa();

	// constructeur priver
	private PersistanceUtils() {
	}

	// Acceder a l'instance unique depuis l'exterieur
	public static PersistanceUtils getInstanceUnique() {
		return instanceUnique;
	}

	public Stockage<Pizza, String> getStockagePizza() {
		return stockagePizza;
	}

}
