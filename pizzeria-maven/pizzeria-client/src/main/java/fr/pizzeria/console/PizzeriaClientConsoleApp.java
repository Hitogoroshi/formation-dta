package fr.pizzeria.console;

import java.io.IOException;
import java.util.Calendar;
import java.util.Scanner;
import java.util.logging.Level;

import org.apache.commons.lang3.time.DateFormatUtils;

import fr.pizzeria.client.IhmHelperClient;
import fr.pizzeria.client.MenuClient;
import fr.pizzeria.model.Client;
import fr.pizzeria.service.Stockage;
import fr.pizzeria.service.StockageClientJpa;

public class PizzeriaClientConsoleApp {

	public static void main(String[] args) throws IOException {

		java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.SEVERE);
		Scanner scanner = new Scanner(System.in);
		Stockage<Client, Integer> stockageClient = new StockageClientJpa();
		IhmHelperClient helper = new IhmHelperClient(stockageClient, scanner);

		// afficher date et heure
		Calendar date = Calendar.getInstance();
		System.out.println(DateFormatUtils.format(date, "dd/MM - HH:mm"));

		// Afficher le Menu

		MenuClient listMenu = new MenuClient(helper);

		listMenu.start();

		scanner.close();
	}

}
