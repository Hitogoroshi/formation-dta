package dta.jdbc;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import dta.StockagePizzaSpringJdbc;
import dta.beans.SpringConfig;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
public class SpringJdbcTest {

	@Autowired
	private StockagePizzaSpringJdbc stockagePizza;

	@Test
	public void testFindAll() {

		stockagePizza.findAll().forEach(System.out::println);
	}

	@Test
	public void testCree() {

		Pizza newPizza = new Pizza("VEG", "Vegetarien", 12.50, CategoriePizza.SANS_VIANDE, "Vegetarien.jpg");
		stockagePizza.save(newPizza);

	}

}
