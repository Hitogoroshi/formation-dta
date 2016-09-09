package fr.pizzeria.model;

import java.util.Calendar;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Commande {

	@Id
	private Integer id;
	private String numeroCommande;
	@Enumerated(EnumType.STRING)
	private StatutCommande statut;
	private Calendar dateCommande;

	@ManyToOne
	@JoinColumn(name = "client_id")
	private Client clientCommande;

	@ManyToOne
	@JoinColumn(name = "livreur_id")
	private Livreur livreurCommande;

	@ManyToMany
	@JoinTable(name = "commande_pizza", joinColumns = @JoinColumn(name = "client_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "pizza_id", referencedColumnName = "id"))
	private Collection<Pizza> Pizza;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumeroCommande() {
		return numeroCommande;
	}

	public void setNumeroCommande(String numeroCommande) {
		this.numeroCommande = numeroCommande;
	}

	public StatutCommande getStatut() {
		return statut;
	}

	public void setStatut(StatutCommande statut) {
		this.statut = statut;
	}

	public Calendar getDateCommande() {
		return dateCommande;
	}

	public void setDateCommande(Calendar dateCommande) {
		this.dateCommande = dateCommande;
	}

	public Commande(String numeroCommande, StatutCommande statut, Calendar dateCommande, Integer id) {
		super();
		this.numeroCommande = numeroCommande;
		this.statut = statut;
		this.dateCommande = dateCommande;
		this.id = id;
	}

}
