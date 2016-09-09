package fr.pizzeria.ihm;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import fr.pizzeria.exception.DebitException;
import fr.pizzeria.exception.SaisieNombreException;
import fr.pizzeria.model.AbstractPersonne;
import fr.pizzeria.model.CompteStat;

public class DebiterClientAction extends Action {

	public DebiterClientAction(IhmHelper helper) {
		super("Debiter un client", helper);
	}

	@Override
	public void execute() throws IOException {
		List<CompteStat> stats = new ArrayList<>();
		stats.addAll(helper.getStockageLivreur().findAll());
		stats.addAll(helper.getStockageClient().findAll());

		stats.forEach(System.out::println);

		System.out.println("choisir l'id de la personne à debiter");
		String id = helper.getScanner().next();
		Optional<? extends AbstractPersonne> personne = helper.findPersonne(id);
		System.out.println("Entrez le montant à debiter");
		try {
			double montant = helper.saisirDouble();

			if (personne.isPresent()) {
				System.out.println("Individu non trouver\n");
			} else {
				personne.get().debiterCompte(montant);
				System.out.println("Debit realiser avec succes\n");
			}
		} catch (DebitException e) {
			System.out.println(e.getMessage());
		} catch (SaisieNombreException e) {
			System.out.println(e.getMessage());
		}

	}

}
