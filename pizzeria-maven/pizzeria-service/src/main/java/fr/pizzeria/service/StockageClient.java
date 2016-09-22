package fr.pizzeria.service;

import java.util.Collection;
import java.util.Map;
import java.util.TreeMap;

import fr.pizzeria.model.Client;

public class StockageClient implements Stockage<Client, Integer> {

	public Map<Integer, Client> clients = new TreeMap<>();

	public StockageClient() {
		this.clients.put(1, new Client("Hunter", "David", 30.50, "login", "motdepasse"));
		this.clients.put(2, new Client("Gaia", "Julie", 345.00, "login", "motdepasse"));
		this.clients.put(3, new Client("Martin", "Jules", 11.50, "login", "motdepasse"));
		this.clients.put(4, new Client("Durand", "Jeremy", 1000.00, "login", "motdepasse"));
		this.clients.put(5, new Client("Famille", "Isabelle", 60.50, "login", "motdepasse"));
		this.clients.put(6, new Client("Figaro", "Giovanni", 4.00, "login", "motdepasse"));
		this.clients.put(7, new Client("Sovari", "Erza", 50.50, "login", "motdepasse"));
		this.clients.put(8, new Client("Legrand", "Guillaume", 26.00, "login", "motdepasse"));

	}

	@Override
	public Collection<Client> findAll() {
		// TODO Auto-generated method stub
		return clients.values();
	}

	@Override
	public void save(Client newClient) {
		// TODO Auto-generated method stub
		newClient.setId(this.clients.size() + 1);
		this.clients.put(newClient.getId(), newClient);
	}

	@Override
	public void update(Client editPizza, Integer code) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Integer ancienCode) {
		// TODO Auto-generated method stub

	}
}
