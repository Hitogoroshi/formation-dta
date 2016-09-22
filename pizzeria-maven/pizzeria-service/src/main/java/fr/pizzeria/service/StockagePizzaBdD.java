package fr.pizzeria.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

import fr.pizzeria.exception.ServiceException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

public class StockagePizzaBdD implements Stockage<Pizza, String> {

	@Override
	public Collection<Pizza> findAll() {

		Collection<Pizza> listPizzas = new ArrayList<>();
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pizzeria?useSSL=false",
				"root", "");
				Statement st = connection.createStatement();
				ResultSet resultat = st.executeQuery("SELECT * FROM PIZZA ORDER BY nom");) {

			while (resultat.next()) {
				Pizza p = new Pizza();
				p.setCode(resultat.getString("code"));
				p.setNom(resultat.getString("nom"));
				p.setPrix(resultat.getBigDecimal("prix").doubleValue());
				p.setCategorie(CategoriePizza.valueOf(resultat.getString("categorie")));
				p.setUrlImage(resultat.getString("urlImage"));
				;
				listPizzas.add(p);
			}

		} catch (SQLException e) {
			throw new ServiceException(e);
		}
		return listPizzas;

	}

	@Override
	public void save(Pizza newPizza) {

		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pizzeria?useSSL=false",
				"root", "");
				PreparedStatement savePizza = connection.prepareStatement(
						"INSERT INTO PIZZA(code, nom, prix, categorie, url_image) VALUES( ?, ?, ?, ?, ?)");) {

			savePizza.setString(1, newPizza.getCode());
			savePizza.setString(2, newPizza.getNom());
			savePizza.setDouble(3, newPizza.getPrix());
			savePizza.setString(4, newPizza.getCategorie().name());
			savePizza.setString(5, newPizza.getNom() + ".jpg");
			savePizza.executeUpdate();
		} catch (SQLException e) {
			throw new ServiceException(e);
		}

	}

	@Override
	public void update(Pizza editPizza, String code) {

		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pizzeria?useSSL=false",
				"root", "");
				PreparedStatement upPizza = connection.prepareStatement(
						"UPDATE PIZZA SET code= ?, nom= ?, prix=?, categorie=?, url_image= ? WHERE reference=?");) {

			upPizza.setString(1, editPizza.getCode());
			upPizza.setString(2, editPizza.getNom());
			upPizza.setDouble(3, editPizza.getPrix());
			upPizza.setString(4, editPizza.getCategorie().name());
			upPizza.setString(5, editPizza.getNom() + ".jpg");
			upPizza.setString(6, code);
			upPizza.executeUpdate();
		} catch (SQLException e) {
			throw new ServiceException(e);
		}

	}

	@Override
	public void delete(String ancienCode) {
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pizzeria?useSSL=false",
				"root", "");
				PreparedStatement delPizza = connection.prepareStatement("DELETE FROM PIZZA WHERE reference = ?");) {

			delPizza.setString(1, ancienCode);
			delPizza.executeUpdate();

		} catch (SQLException e) {
			throw new ServiceException(e);
		}

	}

}
