package dta.jpa;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import dta.repository.IPizzaRepository;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringJpaConfig.class)
public class SpringJpaTest {

	@Autowired
	IPizzaRepository pizzaRepo;

	@Test
	public void test() {

		Pizza p = new Pizza("ORI", "L'orientale", 13.50, CategoriePizza.VIANDE, "L'orientale.jpg");
		pizzaRepo.save(p);

	}

}
