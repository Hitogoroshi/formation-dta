package fr.pizzeria.EJB;

import java.util.Collection;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import fr.pizzeria.model.Client;

@Stateless
public class ClientServiceEJB {

	@PersistenceContext
	private EntityManager em;

	public Collection<Client> findAll() {
		TypedQuery<Client> find = em.createNamedQuery("client.findAllClient", Client.class);
		List<Client> ListClient = find.getResultList();
		return ListClient;
	}

	public void save(Client newClient) {

		em.persist(newClient);
	}

	public void update(Client editClient, Integer id) {
		TypedQuery<Client> find = em.createNamedQuery("client.findByCode", Client.class);
		find.setParameter("id", id);
		Client clientBdd = find.getSingleResult();
		editClient.setId(clientBdd.getId());

		em.merge(editClient);

	}

	public void delete(Integer id) {
		TypedQuery<Client> find = em.createNamedQuery("client.findByCode", Client.class);
		find.setParameter("id", id);
		em.remove(find.getSingleResult());

	}
}
