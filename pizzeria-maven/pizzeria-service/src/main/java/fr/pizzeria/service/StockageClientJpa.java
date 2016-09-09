package fr.pizzeria.service;

import java.util.Collection;

import fr.pizzeria.model.Client;

public class StockageClientJpa implements Stockage<Client> {

	@Override
	public Collection<Client> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Client newPizza) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Client editPizza, String code) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(String ancienCode) {
		// TODO Auto-generated method stub

	}

}
