package dta;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.pizzeria.model.Pizza;
import fr.pizzeria.service.Stockage;
import fr.pizzeria.service.StockagePizzaJpa;

@WebServlet("/deletePizza")
public class DeletePizzaController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String code = req.getParameter("code");

		Stockage<Pizza, String> stockagePizza = new StockagePizzaJpa();
		stockagePizza.delete(code);
		resp.sendRedirect(req.getContextPath() + "/listPizza");

	}

}
