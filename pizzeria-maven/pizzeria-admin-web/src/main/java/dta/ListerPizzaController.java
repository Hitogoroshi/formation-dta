package dta;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.pizzeria.model.Pizza;

public class ListerPizzaController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Collection<Pizza> listpizza = PersistanceUtils.getInstanceUnique().getStockagePizza().findAll();

		req.setAttribute("list_pizza", listpizza);
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/listPizza.jsp");
		dispatcher.forward(req, resp);

	}

}
