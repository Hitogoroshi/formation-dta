package fr.pizzeria.ihm;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import fr.pizzeria.model.CompteStat;

public class AfficheStats extends Action {

	public AfficheStats(IhmHelper helper) {
		super("Affichage des statistique de compte", helper);
	}

	@Override
	public void execute() throws IOException {
		List<CompteStat> stats = new ArrayList<>();
		stats.addAll(helper.getStockageLivreur().findAll());
		stats.addAll(helper.getStockageClient().findAll());
		try {
			Long nbCompte = stats.stream().collect(Collectors.counting());
			double moyenne = stats.stream().collect(Collectors.averagingDouble(CompteStat::getSolde));
			double totSolde = stats.stream().collect(Collectors.counting());
			double minSolde = stats.stream().collect(Collectors.minBy(Comparator.comparing(CompteStat::getSolde))).get()
					.getSolde();
			double maxSolde = stats.stream().collect(Collectors.maxBy(Comparator.comparing(CompteStat::getSolde))).get()
					.getSolde();

			System.out.println("Nombre de compte :" + nbCompte + "\nSolde total des comptes :" + totSolde
					+ " euro\nMoyenne des soldes :" + moyenne + "\nSolde minimum :" + minSolde + "\nSolde maximum :"
					+ maxSolde);
		} catch (NoSuchElementException e) {
			System.out.println("Rien dans la liste");
		}
	}

}
