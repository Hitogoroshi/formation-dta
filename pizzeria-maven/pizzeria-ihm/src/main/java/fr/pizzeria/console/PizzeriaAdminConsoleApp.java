package fr.pizzeria.console;

import java.io.IOException;
import java.util.Calendar;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.logging.Level;

import org.apache.commons.lang3.time.DateFormatUtils;

import fr.pizzeria.ihm.IhmHelper;
import fr.pizzeria.ihm.Menu;
import fr.pizzeria.model.Client;
import fr.pizzeria.model.Livreur;
import fr.pizzeria.model.Pizza;
import fr.pizzeria.service.Stockage;

public class PizzeriaAdminConsoleApp {

	public static void main(String[] args)
			throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException {

		java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.SEVERE);

		Scanner scanner = new Scanner(System.in);

		ResourceBundle bundle = ResourceBundle.getBundle("application");
		String classeStockagePizza = bundle.getString("stockage.pizza");
		Class<?> classePizza = Class.forName(classeStockagePizza);

		String classeStockageClient = bundle.getString("stockage.client");
		Class<?> classeClient = Class.forName(classeStockageClient);

		String classeStockageLivreur = bundle.getString("stockage.livreur");
		Class<?> classLivreur = Class.forName(classeStockageLivreur);

		// On ne peut pas faire autrement pour les supp waring
		@SuppressWarnings("unchecked")
		Stockage<Pizza> stockagePizza = (Stockage<Pizza>) classePizza.newInstance();
		@SuppressWarnings("unchecked")
		Stockage<Client> stockageClient = (Stockage<Client>) classeClient.newInstance();
		@SuppressWarnings("unchecked")
		Stockage<Livreur> stockageLivreur = (Stockage<Livreur>) classLivreur.newInstance();

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
