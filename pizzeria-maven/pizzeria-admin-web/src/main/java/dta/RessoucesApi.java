package dta;

import java.util.Collection;

import javax.ejb.EJB;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import fr.pizzeria.EJB.PizzaServiceEJB;
import fr.pizzeria.model.Pizza;

@Path("/pizzas")
public class RessoucesApi {

	@EJB
	private PizzaServiceEJB stockagePizza;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<Pizza> list() {

		Collection<Pizza> listpizza = stockagePizza.findAll();
		return listpizza;

	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public void cree(Pizza nouvellePizza) {

		nouvellePizza.setUrlImage(nouvellePizza.getNom() + ".jpg");
		stockagePizza.save(nouvellePizza);

	}

	@Path("/{code}")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public void change(Pizza p, @PathParam("code") String code) {

		p.setUrlImage(p.getNom() + ".jpg");
		stockagePizza.update(p, code);

	}

	@Path("/{code}")
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public void supp(@PathParam("code") String code) {

		stockagePizza.delete(code);

	}
}
