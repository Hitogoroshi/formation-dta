package fr.pizzeria.model;

public abstract class AbstractPersonne {

	private Integer id;
	private String nom;
	private String prenom;
	protected double solde;

	public void crediterCompte(double montant) {

		double nouveauSolde = solde + montant;
		this.solde = nouveauSolde;
	}

	public void debiterCompte(double montant) {

		double nouveauSolde = solde - montant;
		this.solde = nouveauSolde;
	}

	public String toString() {

		return (id + "->" + nom + " " + prenom + " ( " + solde + " euro ) ");
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public double getSolde() {
		return solde;
	}

	public void setSolde(double solde) {
		this.solde = solde;
	}

	public AbstractPersonne(int id, String nom, String prenom, double solde) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.solde = solde;
	}
}
