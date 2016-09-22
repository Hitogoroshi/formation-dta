package fr.pizzeria.model;

import javax.persistence.Entity;

import fr.pizzeria.exception.DebitException;

@Entity
public class Livreur extends AbstractPersonne {

	public static final String PREFIX_ID = "L";

	private double montantDecouvertAutoriser;
	/*
	 * @OneToMany(mappedBy = "livreurCommande") private Collection<Commande>
	 * commande;
	 */

	public Livreur(String nom, String prenom, double solde, String login, String motDePasse,
			double MontantDecouvertAutoriser) {
		super(nom, prenom, solde, login, motDePasse);
		this.montantDecouvertAutoriser = MontantDecouvertAutoriser;

	}

	public Livreur() {

	}

	public void debiterCompte(double montant) {

		double nouveauSolde = solde - montant;
		if (nouveauSolde < montantDecouvertAutoriser) {
			throw new DebitException();
		}
		this.solde = nouveauSolde;
	}

	public double getMontantDecouvertAutoriser() {
		return montantDecouvertAutoriser;
	}

	public void setMontantDecouvertAutoriser(double montantDecouvertAutoriser) {
		this.montantDecouvertAutoriser = montantDecouvertAutoriser;
	}

	public String toString() {

		return PREFIX_ID + super.toString();
	}

}
