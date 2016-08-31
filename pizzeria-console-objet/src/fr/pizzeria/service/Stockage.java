package fr.pizzeria.service;

import java.io.IOException;
import java.util.Collection;

public interface Stockage<T> {

	Collection<T> findAll() throws IOException;

	void save(T newPizza) throws IOException;

	void update(T editPizza, String code);

	void delete(String ancienCode);

}
