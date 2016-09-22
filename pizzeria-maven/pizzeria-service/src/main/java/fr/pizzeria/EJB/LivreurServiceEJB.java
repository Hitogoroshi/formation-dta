package fr.pizzeria.EJB;

import java.util.Collection;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import fr.pizzeria.model.Livreur;

@Stateless
public class LivreurServiceEJB {

	@PersistenceContext
	private EntityManager em;

	public Collection<Livreur> findAll() {
		TypedQuery<Livreur> find = em.createNamedQuery("livreur.findAllLivreur", Livreur.class);
		List<Livreur> ListLivreur = find.getResultList();
		return ListLivreur;
	}

	public void save(Livreur newLivreur) {

		em.persist(newLivreur);
	}

	public void update(Livreur editLivreur, Integer id) {
		TypedQuery<Livreur> find = em.createNamedQuery("livreur.findById", Livreur.class);
		find.setParameter("id", id);
		Livreur livreurBdd = find.getSingleResult();
		editLivreur.setId(livreurBdd.getId());

		em.merge(editLivreur);

	}

	public void delete(Integer id) {
		TypedQuery<Livreur> find = em.createNamedQuery("livreur.findById", Livreur.class);
		find.setParameter("id", id);
		em.remove(find.getSingleResult());

	}
}
