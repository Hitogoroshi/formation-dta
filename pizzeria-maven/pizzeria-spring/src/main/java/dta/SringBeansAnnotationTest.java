package dta;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.pizzeria.service.Stockage;

@RunWith(SpringJUnit4ClassRunner.class)
public class SringBeansAnnotationTest {

	@Test
	public void testCreationBean() {

		try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class)) {

			Stockage<?, ?> pizzaStockage = context.getBean(Stockage.class);
			pizzaStockage.findAll().forEach(System.out::println);
		}
	}
}
