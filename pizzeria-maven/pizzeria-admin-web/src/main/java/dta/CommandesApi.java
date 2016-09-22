package dta;

import java.util.Collection;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import fr.pizzeria.EJB.CommandeServiceEJB;
import fr.pizzeria.model.Commande;

@Path("/commandes")
public class CommandesApi {

	@EJB
	private CommandeServiceEJB stockageCommande;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<Commande> list() {

		Collection<Commande> listcommande = stockageCommande.findAll();
		return listcommande;

	}

}
