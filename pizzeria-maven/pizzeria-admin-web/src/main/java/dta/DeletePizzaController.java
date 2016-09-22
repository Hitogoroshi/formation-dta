package dta;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.pizzeria.EJB.PizzaServiceEJB;

@WebServlet("/deletePizza")
public class DeletePizzaController extends HttpServlet {

	@EJB
	private PizzaServiceEJB stockagePizza;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String code = req.getParameter("code");

		stockagePizza.delete(code);
		resp.sendRedirect(req.getContextPath() + "/listPizza");

	}

}
