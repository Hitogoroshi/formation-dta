package dta.transaction;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import dta.StockagePizzaParLotSpringJdbc;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringJdbcTransactionConfig.class)
public class SpringJdbcTransactionTest {

	@Autowired
	private StockagePizzaParLotSpringJdbc stockagePizza;

	@Test
	public void testCreeParLot() {

		List<Pizza> pizzas = new ArrayList<>();

		Pizza newPizza = new Pizza("CHO", "Chorizo", 13.50, CategoriePizza.VIANDE, "Chorizo.jpg");
		pizzas.add(newPizza);
		Pizza newPizza1 = new Pizza("CHB", "Choco Banane", 12.50, CategoriePizza.SANS_VIANDE, "Choco_Banane.jpg");
		pizzas.add(newPizza1);
		Pizza newPizza2 = new Pizza("CHE", "Chevre Miel", 12, CategoriePizza.SANS_VIANDE, "Chevre_Miel.jpg");
		pizzas.add(newPizza2);
		Pizza newPizza3 = new Pizza("MER", "Fruit de mer", 15, CategoriePizza.POISSON, "Fruit_de_mer.jpg");
		pizzas.add(newPizza3);
		Pizza newPizza4 = new Pizza("MER", "4 saisons", 14, CategoriePizza.SANS_VIANDE, "4_saisons.jpg");
		pizzas.add(newPizza4);
		Pizza newPizza5 = new Pizza("CAL", "Calzone", 13, CategoriePizza.VIANDE, "Calzone.jpg");
		pizzas.add(newPizza5);
		Pizza newPizza6 = new Pizza("IND", "Indienne", 13.50, CategoriePizza.VIANDE, "Indienne.jpg");
		pizzas.add(newPizza6);
		Pizza newPizza7 = new Pizza("CHI", "Chinoise", 14.50, CategoriePizza.VIANDE, "Chinoise.jpg");
		pizzas.add(newPizza7);

		stockagePizza.insererParLot(pizzas);

	}

}
