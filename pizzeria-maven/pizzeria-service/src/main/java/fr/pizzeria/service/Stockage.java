package fr.pizzeria.service;

import java.util.Collection;

public interface Stockage<T> {

	Collection<T> findAll();

	void save(T newPizza);

	void update(T editPizza, String code);

	void delete(String ancienCode);

}
