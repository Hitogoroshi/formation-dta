package fr.pizzeria.service;

import java.util.Collection;

import fr.pizzeria.exception.ServiceNonImplementeException;
import fr.pizzeria.model.Livreur;

public class StockageLivreurJpa implements Stockage<Livreur> {

	@Override
	public Collection<Livreur> findAll() {
		throw new ServiceNonImplementeException();
	}

	@Override
	public void save(Livreur newPizza) {
		throw new ServiceNonImplementeException();
	}

	@Override
	public void update(Livreur editPizza, String code) {
		throw new ServiceNonImplementeException();
	}

	@Override
	public void delete(String ancienCode) {
		throw new ServiceNonImplementeException();
	}

}
