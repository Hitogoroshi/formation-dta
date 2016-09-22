package dta;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import fr.pizzeria.model.Pizza;
import fr.pizzeria.service.Stockage;

public class SpringBeansXmlTest {

	@Test
	public void testCreationBean() {

		try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml")) {

			Stockage<?, ?> pizzaStockage = context.getBean(Stockage.class);
			pizzaStockage.findAll().forEach(System.out::println);
		}
		;
	}

	@Test
	public void testPrizza() {

		try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml")) {

			Pizza maPizza = context.getBean(Pizza.class);
			Assert.assertEquals("RPR", maPizza.getCode());
		}
		;
	}

}
