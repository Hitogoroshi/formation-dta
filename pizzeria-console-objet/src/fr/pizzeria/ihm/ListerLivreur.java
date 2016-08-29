package fr.pizzeria.ihm;

import java.util.Collection;

import fr.pizzeria.model.Livreur;

public class ListerLivreur extends Action {

	public ListerLivreur(IhmHelper helper) {
		super("liste de liveurs", helper);
		// TODO Auto-generated constructor stub
	}

	public void execute() {
		System.out.println("**** Liste de Livreurs ****");
		Collection<Livreur> livreurs = this.helper.getStockageLivreur().findAll();
		for (Livreur LivreurEnCours : livreurs) {
			System.out.println(LivreurEnCours.toString());
		}
		System.out.println("\n");
	}

}
