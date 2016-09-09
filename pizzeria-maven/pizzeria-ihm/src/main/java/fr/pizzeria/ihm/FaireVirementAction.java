package fr.pizzeria.ihm;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import fr.pizzeria.exception.CreditException;
import fr.pizzeria.exception.DebitException;
import fr.pizzeria.exception.SaisieNombreException;
import fr.pizzeria.model.AbstractPersonne;
import fr.pizzeria.model.CompteStat;

public class FaireVirementAction extends Action {

	public FaireVirementAction(IhmHelper helper) {
		super("Realiser un virement entre comptes", helper);
	}

	@Override
	public void execute() throws IOException {
		List<CompteStat> stats = new ArrayList<>();
		stats.addAll(helper.getStockageLivreur().findAll());
		stats.addAll(helper.getStockageClient().findAll());

		stats.forEach(System.out::println);

		System.out.println("choisir l'id de la personne qui realise le virement et vas donc etre debiter");
		String id1 = helper.getScanner().next();
		Optional<? extends AbstractPersonne> personne1 = helper.findPersonne(id1);
		System.out.println("choisir l'id de la personne vers ou est realiser le virement et vas donc etre crediter");
		String id2 = helper.getScanner().next();
		Optional<? extends AbstractPersonne> personne2 = helper.findPersonne(id2);
		System.out.println("Entrez le montant à debiter au premier compte et crediter au second");
		try {
			double montant = helper.saisirDouble();

			if (id1.equals(id2)) {
				System.out.println("Entrez des individus différents !\n");
			} else if (personne1.isPresent() || personne2.isPresent()) {
				System.out.println("Individu 1 ou individu 2 non trouver\n");
			} else {

				personne1.get().debiterCompte(montant);
				personne2.get().crediterCompte(montant);
				System.out.println("Virement realiser avec succes\n");

			}
		} catch (DebitException e) {
			System.out.println(e.getMessage());
		} catch (CreditException e) {
			System.out.println(e.getMessage());
		} catch (SaisieNombreException e) {
			System.out.println(e.getMessage());
		}

	}

}
