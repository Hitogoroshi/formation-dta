package fr.pizzeria.EJB;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.ejb.Schedule;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import fr.pizzeria.model.Client;
import fr.pizzeria.model.Commande;
import fr.pizzeria.model.Livreur;
import fr.pizzeria.model.Pizza;
import fr.pizzeria.model.StatutCommande;

@Stateless
public class CommandeServiceEJB {

	@PersistenceContext
	private EntityManager em;

	public Collection<Commande> findAll() {
		TypedQuery<Commande> find = em.createQuery("SELECT c FROM Commande c join fetch c.pizza ", Commande.class);
		Set<Commande> ListCommande = new HashSet<>(find.getResultList());
		return ListCommande;
	}

	@Schedule(minute = "*", hour = "*")
	public void save() {

		Calendar date = Calendar.getInstance();
		String dateCommande = new SimpleDateFormat("dd/MM/yyyy-HH:mm").format(date.getTime());
		Integer clientId = (int) ((Math.random() * (3 - 1 + 1)) + 1);
		Client client = em.getReference(Client.class, clientId);
		Integer livreurId = 4;
		Livreur livreur = em.getReference(Livreur.class, livreurId);
		String numcommande = "C" + clientId + "/L" + livreurId + "-" + dateCommande;
		Collection<Pizza> pizza = new ArrayList<>();
		TypedQuery<Pizza> find = em.createQuery("SELECT p FROM Pizza p ", Pizza.class);
		pizza.addAll(find.getResultList());

		Commande newCommande = new Commande(numcommande, StatutCommande.NON, date, client, livreur, pizza);
		em.persist(newCommande);
	}

	public void update(Commande editCommande, String numero) {

		em.merge(editCommande);

	}

	public void delete(String ancienNumero) {

		em.remove(ancienNumero);

	}
}
