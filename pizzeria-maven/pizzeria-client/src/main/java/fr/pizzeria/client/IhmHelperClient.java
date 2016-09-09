package fr.pizzeria.client;

import java.util.Scanner;

import fr.pizzeria.exception.SaisieNombreException;
import fr.pizzeria.model.Client;
import fr.pizzeria.service.Stockage;

public class IhmHelperClient {

	private Stockage<Client, Integer> stockageClient;
	private Scanner scanner;

	public IhmHelperClient(Stockage<Client, Integer> stockageC, Scanner scanner) {
		this.scanner = scanner;
		this.setStockageClient(stockageC);
	}

	public int saisirEntier() throws SaisieNombreException {
		try {
			String saisie = scanner.next();
			return Integer.parseInt(saisie);
		} catch (NumberFormatException e) {
			throw new SaisieNombreException(e);
		}
	}

	public double saisirDouble() throws SaisieNombreException {
		try {
			String saisie = scanner.next();
			return Double.parseDouble(saisie);
		} catch (NumberFormatException e) {
			throw new SaisieNombreException(e);
		}
	}

	public Scanner getScanner() {
		return scanner;
	}

	public Stockage<Client, Integer> getStockageClient() {
		return stockageClient;
	}

	public void setStockageClient(Stockage<Client, Integer> stockageClient) {
		this.stockageClient = stockageClient;
	}

}
