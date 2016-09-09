package fr.pizzeria.service;

import java.util.Collection;
import java.util.Map;
import java.util.TreeMap;

import fr.pizzeria.model.Livreur;

public class StockageLivreur implements Stockage<Livreur, Integer> {

	public Map<Integer, Livreur> livreurs = new TreeMap<>();

	public StockageLivreur() {
		this.livreurs.put(1, new Livreur(1, "Dupuit", "Gaelle", 26.50, "login", "motdepasse", 50));
		this.livreurs.put(2, new Livreur(2, "Lacroix", "Judith", 12.00, "login", "motdepasse", 50));
	}

	public Collection<Livreur> findAll() {
		return livreurs.values();
	}

	public void save(Livreur newLivreur) {
		newLivreur.setId(this.livreurs.size() + 1);
		this.livreurs.put(newLivreur.getId(), newLivreur);
	}

	@Override
	public void update(Livreur editPizza, Integer code) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Integer ancienCode) {
		// TODO Auto-generated method stub

	}

}
