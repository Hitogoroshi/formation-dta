package fr.pizzeria.ihm;

import java.util.ArrayList;
import java.util.List;

import fr.pizzeria.exception.CreditException;
import fr.pizzeria.exception.DebitException;
import fr.pizzeria.model.AbstractPersonne;
import fr.pizzeria.model.CompteStat;

public class FaireVirementAction extends Action {

	public FaireVirementAction(IhmHelper helper) {
		super("Realiser un virement entre comptes", helper);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void execute() {
		List<CompteStat> stats = new ArrayList<>();
		stats.addAll(helper.getStockageLivreur().findAll());
		stats.addAll(helper.getStockageClient().findAll());

		for (CompteStat personneEnCours : stats) {
			System.out.println(personneEnCours.toString());
		}

		System.out.println("choisir l'id de la personne qui realise le virement et vas donc etre debiter");
		String id1 = helper.getScanner().next();
		AbstractPersonne personne1 = helper.findPersonne(id1);
		System.out.println("choisir l'id de la personne vers ou est realiser le virement et vas donc etre crediter");
		String id2 = helper.getScanner().next();
		AbstractPersonne personne2 = helper.findPersonne(id2);
		System.out.println("Entrez le montant à debiter au premier compte et crediter au second");
		double montant = helper.getScanner().nextInt();

		if (id1.equals(id2)) {
			System.out.println("Entrez des individus différents !\n");
		} else if (personne1 == null || personne2 == null) {
			System.out.println("Individu 1 ou individu 2 non trouver\n");
		} else {
			try {
				personne1.debiterCompte(montant);
				personne2.crediterCompte(montant);
				System.out.println("Virement realiser avec succes\n");
			} catch (DebitException e) {
				System.out.println(e.getMessage());
			} catch (CreditException e) {
				System.out.println(e.getMessage());
			}

		}

	}

}
