package fr.pizzeria.model;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import fr.pizzeria.exception.DebitException;

@Entity
public class Livreur extends AbstractPersonne {

	public static final String PREFIX_ID = "L";

	private double montantDecouvertAutoriser;
	@OneToMany(mappedBy = "livreurCommande")
	private Collection<Commande> commande;

	public Livreur(int id, String nom, String prenom, double solde, String login, String motDePasse,
			double MontantDecouvertAutoriser) {
		super(id, nom, prenom, solde, login, motDePasse);
		this.montantDecouvertAutoriser = MontantDecouvertAutoriser;

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
