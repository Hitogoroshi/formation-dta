package fr.pizzeria.model;

public class Pizza {

	private String code;
	private String nom;
	private double prix;
	private CategoriePizza categorie;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public CategoriePizza getCategorie() {
		return categorie;
	}

	public void setCategorie(CategoriePizza categorie) {
		this.categorie = categorie;
	}

	public Pizza(String code, String nom, double prix, CategoriePizza categorie) {
		super();
		this.code = code;
		this.nom = nom;
		this.prix = prix;
		this.categorie = categorie;
	}

	public Pizza() {
		// TODO Auto-generated constructor stub
	}

	public void setPrix(String string) {
		// TODO Auto-generated method stub

	}

	public void setCategorie(String string) {
		// TODO Auto-generated method stub

	}

}
