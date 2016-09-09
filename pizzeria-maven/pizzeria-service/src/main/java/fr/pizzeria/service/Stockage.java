package fr.pizzeria.service;

import java.util.Collection;

public interface Stockage<T, C> {

	Collection<T> findAll();

	void save(T newPizza);

	void update(T editPizza, C code);

	void delete(C ancienCode);

}
