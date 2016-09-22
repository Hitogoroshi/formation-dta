package fr.pizzeria.model;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Commande {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
	private Collection<Pizza> pizza;

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

	public Client getClientCommande() {
		return clientCommande;
	}

	public void setClientCommande(Client clientCommande) {
		this.clientCommande = clientCommande;
	}

	public Livreur getLivreurCommande() {
		return livreurCommande;
	}

	public void setLivreurCommande(Livreur livreurCommande) {
		this.livreurCommande = livreurCommande;
	}

	public Collection<Pizza> getPizza() {
		return pizza;
	}

	public void setPizza(Collection<Pizza> pizza) {
		this.pizza = pizza;
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

	public String getDateSympa() {
		return new SimpleDateFormat("dd/MM/yyyy HH:mm").format(dateCommande.getTime());
	}

	public void setDateCommande(Calendar dateCommande) {
		this.dateCommande = dateCommande;
	}

	public Commande(String numeroCommande, StatutCommande statut, Calendar dateCommande, Client clientCommande,
			Livreur livreurCommande, Collection<Pizza> Pizza) {
		super();
		this.numeroCommande = numeroCommande;
		this.statut = statut;
		this.dateCommande = dateCommande;
		this.clientCommande = clientCommande;
		this.livreurCommande = livreurCommande;
		this.pizza = Pizza;
	}

	public Commande() {
		super();

	}

}
