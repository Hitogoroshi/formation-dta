package fr.pizzeria.service;

import java.util.Collection;
import java.util.List;
import java.util.function.Consumer;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import fr.pizzeria.model.Client;

public class StockageClientJpa implements Stockage<Client, Integer> {

	private EntityManagerFactory emf;

	public StockageClientJpa() {
		this.emf = Persistence.createEntityManagerFactory("pizzeria-unit");
	}

	@Override
	public Collection<Client> findAll() {
		EntityManager em = emf.createEntityManager();
		TypedQuery<Client> find = em.createNamedQuery("client.findAllClient", Client.class);
		List<Client> ListClient = find.getResultList();
		em.close();
		return ListClient;
	}

	@Override
	public void save(Client newClient) {
		executeUneTransaction(em -> {
			em.persist(newClient);
		});

	}

	@Override
	public void update(Client editClient, Integer id) {
		executeUneTransaction(em -> {
			TypedQuery<Client> find = em.createNamedQuery("client.findById", Client.class);
			find.setParameter("id", id);
			Client clientBdd = find.getSingleResult();
			editClient.setId(clientBdd.getId());

			em.merge(editClient);
		});

	}

	@Override
	public void delete(Integer ancienId) {
		executeUneTransaction(em -> {
			TypedQuery<Client> find = em.createNamedQuery("client.findById", Client.class);
			find.setParameter("id", ancienId);
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
			et.rollback();
		}
		em.close();
	}

}
