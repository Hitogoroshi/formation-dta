package dta;

import java.io.IOException;
import java.util.Collection;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.pizzeria.model.Pizza;
import fr.pizzeria.service.Stockage;

@WebServlet("/listPizza")
public class ListerPizzaController extends HttpServlet {

	@Inject
	private Stockage<Pizza, String> stockagePizza;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Collection<Pizza> listpizza = stockagePizza.findAll();

		req.setAttribute("list_pizza", listpizza);
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/listPizza.jsp");
		dispatcher.forward(req, resp);

	}

}
