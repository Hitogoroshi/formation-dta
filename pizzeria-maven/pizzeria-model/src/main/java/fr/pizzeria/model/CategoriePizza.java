package fr.pizzeria.model;

public enum CategoriePizza {

	VIANDE("Viande"), POISSON("Poisson"), SANS_VIANDE("Sans Viande");

	private String nom = "";

	CategoriePizza(String nom) {
		this.nom = nom;
	}

	public String toString() {
		return nom;
	}

}