package fr.pizzeria.model;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import fr.pizzeria.exception.CreditException;
import fr.pizzeria.exception.DebitException;

@Entity
@NamedQueries({ @NamedQuery(name = "client.findAllClient", query = "SELECT c FROM Client c ORDER BY nom"),
		@NamedQuery(name = "client.findById", query = "SELECT c FROM Pizza c WHERE  c.id =:id") })
public class Client extends AbstractPersonne {

	public static final String PREFIX_ID = "C";
	/*
	 * @OneToMany(mappedBy = "clientCommande") private Collection<Commande>
	 * commande;
	 */

	public Client(String nom, String prenom, double solde, String login, String motDePasse) {
		super(nom, prenom, solde, login, motDePasse);

	}

	public Client() {
		super();

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
