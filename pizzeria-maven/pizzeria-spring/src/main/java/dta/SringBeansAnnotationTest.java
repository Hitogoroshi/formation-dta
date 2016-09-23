package dta;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import fr.pizzeria.service.Stockage;

public class SringBeansAnnotationTest {

	@Test
	public void testCreationBean() {

		try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class)) {

			Stockage<?, ?> pizzaStockage = context.getBean(Stockage.class);
			pizzaStockage.findAll().forEach(System.out::println);
		}
	}
}
