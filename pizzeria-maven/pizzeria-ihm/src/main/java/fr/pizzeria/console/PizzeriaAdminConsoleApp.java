package fr.pizzeria.console;

import java.io.IOException;
import java.util.Calendar;
import java.util.ResourceBundle;
import java.util.Scanner;

import org.apache.commons.lang3.time.DateFormatUtils;

import fr.pizzeria.ihm.IhmHelper;
import fr.pizzeria.ihm.Menu;
import fr.pizzeria.model.Client;
import fr.pizzeria.model.Livreur;
import fr.pizzeria.model.Pizza;
import fr.pizzeria.service.Stockage;
import fr.pizzeria.service.StockageClient;
import fr.pizzeria.service.StockageLivreur;

public class PizzeriaAdminConsoleApp {

	public static void main(String[] args)
			throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException {

		Scanner scanner = new Scanner(System.in);

		ResourceBundle bundle = ResourceBundle.getBundle("application");
		String classeStockagePizza = bundle.getString("stockage.pizza");
		System.out.println(classeStockagePizza);
		Class<?> classePizza = Class.forName(classeStockagePizza);

		Stockage<Pizza> stockagePizza = (Stockage<Pizza>) classePizza.newInstance();
		Stockage<Client> stockageClient = new StockageClient();
		Stockage<Livreur> stockageLivreur = new StockageLivreur();

		IhmHelper helper = new IhmHelper(stockagePizza, stockageClient, stockageLivreur, scanner);

		// afficher date et heure
		Calendar date = Calendar.getInstance();
		System.out.println(DateFormatUtils.format(date, "dd/MM - HH:mm"));

		// Afficher le Menu

		Menu listMenu = new Menu(helper);

		listMenu.start();

		scanner.close();

	}

}