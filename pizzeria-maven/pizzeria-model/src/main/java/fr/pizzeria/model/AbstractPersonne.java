package fr.pizzeria.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class AbstractPersonne implements CompteStat {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nom;
	private String prenom;
	protected double solde;
	protected String login;
	protected String motDePasse;

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

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getmotDePasse() {
		return motDePasse;
	}

	public void setMot_de_passe(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	public AbstractPersonne(int id, String nom, String prenom, double solde, String login, String motDePasse) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.solde = solde;
		this.login = login;
		this.motDePasse = motDePasse;
	}
}
