package dta;

import java.util.Collection;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;
import fr.pizzeria.service.Stockage;

@Repository
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class StockagePizzaSpringJdbc implements Stockage<Pizza, String> {

	private JdbcTemplate jdbcTemplate;

	@Autowired // Constructor
	public StockagePizzaSpringJdbc(DataSource datasource) {
		this.jdbcTemplate = new JdbcTemplate(datasource);
	}

	@Override
	public Collection<Pizza> findAll() {

		return this.jdbcTemplate.query("SELECT * FROM PIZZA", (resultat, rowNumber) -> {

			Pizza p = new Pizza();
			p.setCode(resultat.getString("code"));
			p.setNom(resultat.getString("nom"));
			p.setPrix(resultat.getBigDecimal("prix").doubleValue());
			p.setCategorie(CategoriePizza.valueOf(resultat.getString("categorie")));
			p.setUrlImage(resultat.getString("urlImage"));
			return p;

		});
	}

	@Override
	public void save(Pizza newPizza) {

		String sql = "INSERT INTO PIZZA(code, nom, prix, categorie, urlImage) VALUES( ?, ?, ?, ?, ?)";
		this.jdbcTemplate.update(sql, newPizza.getCode(), newPizza.getNom(), newPizza.getPrix(),
				newPizza.getCategorie().toString(), newPizza.getUrlImage());

	}

	public void saveAll(List<Pizza> ListPizzas) {

		ListPizzas.forEach(this::save);

	}

	@Override
	public void update(Pizza editPizza, String code) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(String ancienCode) {
		// TODO Auto-generated method stub

	}

}
