package fr.pizzeria.service;

import java.util.Collection;
import java.util.List;
import java.util.function.Consumer;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Component;

import fr.pizzeria.exception.ServiceException;
import fr.pizzeria.model.Pizza;

@Component
public class StockagePizzaJpa implements Stockage<Pizza, String> {

	private EntityManagerFactory emf;

	public StockagePizzaJpa() {
		this.emf = Persistence.createEntityManagerFactory("pizzeria-unit");
	}

	@Override
	public Collection<Pizza> findAll() {
		EntityManager em = emf.createEntityManager();
		TypedQuery<Pizza> find = em.createNamedQuery("pizza.findAllPizza", Pizza.class);
		List<Pizza> ListPizza = find.getResultList();
		em.close();
		return ListPizza;
	}

	@Override
	public void save(Pizza newPizza) {

		executeUneTransaction(em -> {
			newPizza.setUrlImage(newPizza.getNom() + ".jpg");
			em.persist(newPizza);
		});

	}

	@Override
	public void update(Pizza editPizza, String code) {

		executeUneTransaction(em -> {
			TypedQuery<Pizza> find = em.createNamedQuery("pizza.findByCode", Pizza.class);
			find.setParameter("code", code);
			Pizza pizzaBdd = find.getSingleResult();
			editPizza.setId(pizzaBdd.getId());

			em.merge(editPizza);
		});
	}

	@Override
	public void delete(String ancienCode) {

		executeUneTransaction(em -> {
			TypedQuery<Pizza> find = em.createNamedQuery("pizza.findByCode", Pizza.class);
			find.setParameter("code", ancienCode);
			em.remove(find.getSingleResult());
		});
	}

	public void executeUneTransaction(Consumer<EntityManager> objetExecutable) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		try {
			objetExecutable.accept(em);
			et.commit();
		} catch (PersistenceException e) {
			Logger.getGlobal().log(Level.SEVERE, "Problème base de données", e);
			et.rollback();
			em.close();
			throw new ServiceException(e);
		}
		em.close();
	}

}
