package dta;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.pizzeria.model.Pizza;
import fr.pizzeria.service.Stockage;
import fr.pizzeria.service.StockagePizzaJpa;

public class EditPizzaController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/editPizza.jsp");

		Stockage<Pizza, String> stockagePizza = new StockagePizzaJpa();
		Collection<Pizza> listpizza = stockagePizza.findAll();
		String anciencode = req.getParameter("code");

		listpizza.forEach(p -> {
			if (anciencode.equals(p.getCode())) {

				req.setAttribute("pizza", p);
				try {
					dispatcher.forward(req, resp);
				} catch (ServletException | IOException e) {
					e.printStackTrace();
				}
			}
		});

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}

}
