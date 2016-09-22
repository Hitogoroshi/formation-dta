package dta;

import javax.ejb.EJB;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import fr.pizzeria.EJB.ClientServiceEJB;
import fr.pizzeria.EJB.LivreurServiceEJB;
import fr.pizzeria.EJB.PizzaServiceEJB;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Client;
import fr.pizzeria.model.Livreur;
import fr.pizzeria.model.Pizza;

@WebListener
public class EcouteurDebutApp implements ServletContextListener {

	@EJB
	private PizzaServiceEJB pizzaService;
	@EJB
	private ClientServiceEJB clientService;
	@EJB
	private LivreurServiceEJB livreurService;

	@Override
	public void contextInitialized(ServletContextEvent sce) {

		Pizza newPizza = new Pizza("PEP", "La Pépéroni", 12.50, CategoriePizza.VIANDE);
		pizzaService.save(newPizza);
		Pizza newPizza1 = new Pizza("MAR", " La Margherita", 14.00, CategoriePizza.SANS_VIANDE);
		pizzaService.save(newPizza1);
		Pizza newPizza2 = new Pizza("REI", "La Reine", 11.50, CategoriePizza.VIANDE);
		pizzaService.save(newPizza2);
		Pizza newPizza3 = new Pizza("FRO", "La 4 fromages", 12.00, CategoriePizza.SANS_VIANDE);
		pizzaService.save(newPizza3);
		Pizza newPizza4 = new Pizza("CAN", "La cannibale", 12.50, CategoriePizza.VIANDE);
		pizzaService.save(newPizza4);
		Pizza newPizza5 = new Pizza("SAV", "La savoyarde", 13.00, CategoriePizza.SANS_VIANDE);
		pizzaService.save(newPizza5);
		Pizza newPizza6 = new Pizza("SAU", "La saumon", 15.00, CategoriePizza.POISSON);
		pizzaService.save(newPizza6);

		Client newClient = new Client("Hunter", "David", 30.50, "login", "motdepasse");
		clientService.save(newClient);
		Client newClient1 = new Client("Gaia", "Julie", 345.00, "login", "motdepasse");
		clientService.save(newClient1);
		Client newClient2 = new Client("Martin", "Jules", 11.50, "login", "motdepasse");
		clientService.save(newClient2);

		Livreur newLivreur = new Livreur("Dupuit", "Gaelle", 26.50, "login", "motdepasse", 50);
		livreurService.save(newLivreur);
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {

	}

}
