package fr.pizzeria.ihm;

import java.util.ArrayList;
import java.util.List;

import fr.pizzeria.exception.CreditException;
import fr.pizzeria.exception.DebitException;
import fr.pizzeria.model.AbstractPersonne;
import fr.pizzeria.model.Client;
import fr.pizzeria.model.CompteStat;
import fr.pizzeria.model.Livreur;
import fr.pizzeria.service.Stockage;

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
		AbstractPersonne personne1 = findPersonne(id1);
		System.out.println("choisir l'id de la personne vers ou est realiser le virement et vas donc etre crediter");
		String id2 = helper.getScanner().next();
		AbstractPersonne personne2 = findPersonne(id2);
		System.out.println("Entrez le montant à debiter au premier compte et crediter au second");
		double montant = helper.getScanner().nextInt();

		if (id1.equals(id2)) {
			System.out.println("Entrez des individus différents !");
		} else if (personne1 == null || personne2 == null) {
			System.out.println("xxx");
		} else {
			try {
				personne1.debiterCompte(montant);
				personne2.crediterCompte(montant);
				System.out.println("Virement realiser avec succes");
			} catch (DebitException e) {
				System.out.println(e.getMessage());
			} catch (CreditException e) {
				System.out.println(e.getMessage());
			}

		}

	}

	public AbstractPersonne findPersonne(String idRecherche) {

		if (idRecherche.startsWith(Livreur.PREFIX_ID)) {
			return find(idRecherche, Livreur.PREFIX_ID, helper.getStockageLivreur());

		} else if (idRecherche.startsWith(Client.PREFIX_ID)) {
			return find(idRecherche, Client.PREFIX_ID, helper.getStockageClient());
		}
		return null;
	}

	private AbstractPersonne find(String idRecherche, String prefixId, Stockage<? extends AbstractPersonne> stockage) {
		String id = idRecherche.replace(prefixId, "");
		// "1223" -> 1223
		Integer idInt = Integer.valueOf(id);
		for (AbstractPersonne personne : stockage.findAll()) {
			if (personne.getId() == idInt) {
				return personne;
			}
		}
		return null;
	}

}
