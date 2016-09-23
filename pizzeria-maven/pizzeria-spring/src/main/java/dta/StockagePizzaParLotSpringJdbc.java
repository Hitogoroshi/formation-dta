package dta;

import java.util.List;

import org.apache.commons.collections4.ListUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.pizzeria.model.Pizza;

@Repository
public class StockagePizzaParLotSpringJdbc {

	@Autowired
	StockagePizzaSpringJdbc stockagePizza;

	@Transactional
	public void insererParLot(List<Pizza> ListPizzas) {

		ListUtils.partition(ListPizzas, 3).forEach(stockagePizza::saveAll);

	}
}
