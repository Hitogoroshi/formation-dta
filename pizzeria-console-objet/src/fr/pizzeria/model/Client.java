package fr.pizzeria.model;

import fr.pizzeria.exception.CreditException;
import fr.pizzeria.exception.DebitException;

public class Client extends AbstractPersonne {

	public static final String PREFIX_ID = "C";

	public Client(int id, String nom, String prenom, double solde) {
		super(id, nom, prenom, solde);
		// TODO Auto-generated constructor stub
	}

	public void crediterCompte(double montant) {

		double nouveauSolde = solde + montant;
		if (nouveauSolde > 5000) {
			throw new CreditException();
		}
		this.solde = nouveauSolde;
	}

	public void debiterCompte(double montant) {

		double nouveauSolde = solde - montant;
		if (nouveauSolde < 0) {
			throw new DebitException();
		}
		this.solde = nouveauSolde;
	}

	public String toString() {

		return PREFIX_ID + super.toString();
	}

}
