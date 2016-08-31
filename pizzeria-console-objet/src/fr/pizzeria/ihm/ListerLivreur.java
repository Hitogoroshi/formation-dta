package fr.pizzeria.ihm;

import java.io.IOException;
import java.util.Collection;

import fr.pizzeria.model.Livreur;

public class ListerLivreur extends Action {

	public ListerLivreur(IhmHelper helper) {
		super("Lister les liveurs", helper);
		// TODO Auto-generated constructor stub
	}

	public void execute() throws IOException {
		System.out.println("**** Liste de Livreurs ****");
		Collection<Livreur> livreurs = this.helper.getStockageLivreur().findAll();
		// Java 8
		livreurs.forEach(System.out::println);
		System.out.println("\n");
	}

}
