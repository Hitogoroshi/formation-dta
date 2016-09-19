package dta;

import java.util.Calendar;

import javax.enterprise.event.Observes;

import fr.pizzeria.model.Pizza;

public class CreerPizzaEvent {

	private Pizza pizza = new Pizza();
	private Calendar Date;

	public Pizza getPizza() {
		return pizza;
	}

	public void setPizza(Pizza pizza) {
		this.pizza = pizza;
	}

	public Calendar getDate() {
		return Date;
	}

	public void setDate(Calendar date) {
		Date = date;
	}

	public CreerPizzaEvent(Pizza pizza, Calendar date) {
		super();
		this.pizza = pizza;
		Date = date;
	}

	public void ecouteMonEvent(@Observes CreerPizzaEvent event) {

	}
}
