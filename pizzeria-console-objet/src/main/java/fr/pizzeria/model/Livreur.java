package fr.pizzeria.model;

public class Livreur extends AbstractPersonne {

	public static final String PREFIX_ID = "L";

	private double MontantDecouvertAutoriser;

	public Livreur(int id, String nom, String prenom, double solde) {
		super(id, nom, prenom, solde);
		// TODO Auto-generated constructor stub
	}

	public double getMontantDecouvertAutoriser() {
		return MontantDecouvertAutoriser;
	}

	public void setMontantDecouvertAutoriser(double montantDecouvertAutoriser) {
		MontantDecouvertAutoriser = montantDecouvertAutoriser;
	}

	public String toString() {

		return PREFIX_ID + super.toString();
	}

}
