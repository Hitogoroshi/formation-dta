package fr.pizzeria.model;

public enum StatutCommande {

	NON("Non traitée"), EN_COURS("en cours de preparation"), EN_LIVRAISON("en livraison"), LIVRE("livré");

	private String nom = "";

	StatutCommande(String nom) {
		this.nom = nom;
	}

	public String toString() {
		return nom;
	}

}
