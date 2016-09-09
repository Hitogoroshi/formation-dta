package fr.pizzeria.service;

import java.util.Collection;

import fr.pizzeria.exception.ServiceNonImplementeException;
import fr.pizzeria.model.Livreur;

public class StockageLivreurJpa implements Stockage<Livreur, Integer> {

	@Override
	public Collection<Livreur> findAll() {
		throw new ServiceNonImplementeException();
	}

	@Override
	public void save(Livreur newPizza) {
		throw new ServiceNonImplementeException();
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
