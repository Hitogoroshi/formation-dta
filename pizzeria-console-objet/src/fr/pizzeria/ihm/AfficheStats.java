package fr.pizzeria.ihm;

import java.util.ArrayList;
import java.util.List;

import fr.pizzeria.model.CompteStat;

public class AfficheStats extends Action {

	public AfficheStats(IhmHelper helper) {
		super("Affichage des statistique de compte", helper);
	}

	@Override
	public void execute() {
		List<CompteStat> stats = new ArrayList<>();
		stats.addAll(helper.getStockageLivreur().findAll());
		stats.addAll(helper.getStockageClient().findAll());

		int nbCompte = 0;
		double moyenne = 0;
		double totSolde = 0;
		double minSolde = 5000;
		double maxSolde = 0;
		for (CompteStat personneEnCours : stats) {
			if (personneEnCours.getSolde() > maxSolde) {
				maxSolde = personneEnCours.getSolde();
			}
			if (personneEnCours.getSolde() < minSolde) {
				minSolde = personneEnCours.getSolde();
			}
			totSolde += personneEnCours.getSolde();
			nbCompte++;
		}
		moyenne = totSolde / nbCompte;
		System.out.println("Nombre de compte :" + nbCompte + "\n Solde total des comptes :" + totSolde
				+ " euro\n Moyenne des soldes :" + moyenne + "\n Solde minimum :" + minSolde + "\n Solde maximum :"
				+ maxSolde);
	}

}
