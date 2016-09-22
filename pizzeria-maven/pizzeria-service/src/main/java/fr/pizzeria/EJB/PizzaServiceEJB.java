package fr.pizzeria.EJB;

import java.util.Collection;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import fr.pizzeria.model.Pizza;

@Stateless
public class PizzaServiceEJB {

	@PersistenceContext
	private EntityManager em;

	public Collection<Pizza> findAll() {
		TypedQuery<Pizza> find = em.createNamedQuery("pizza.findAllPizza", Pizza.class);
		List<Pizza> ListPizza = find.getResultList();
		return ListPizza;
	}

	public void save(Pizza newPizza) {
		newPizza.setUrlImage(newPizza.getNom() + ".jpg");
		em.persist(newPizza);
	}

	public void update(Pizza editPizza, String code) {
		TypedQuery<Pizza> find = em.createNamedQuery("pizza.findByCode", Pizza.class);
		find.setParameter("code", code);
		Pizza pizzaBdd = find.getSingleResult();
		editPizza.setId(pizzaBdd.getId());

		em.merge(editPizza);

	}

	public void delete(String ancienCode) {
		TypedQuery<Pizza> find = em.createNamedQuery("pizza.findByCode", Pizza.class);
		find.setParameter("code", ancienCode);
		em.remove(find.getSingleResult());

	}

}
