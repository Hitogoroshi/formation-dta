package dta;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.pizzeria.exception.ServiceException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;
import fr.pizzeria.service.StockagePizzaJpa;

public class NouvellePizzaController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/newpizza.jsp");
		dispatcher.forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setCharacterEncoding("UTF-8");
		String code = req.getParameter("code");
		String nom = req.getParameter("nom");
		double prix = Double.valueOf(req.getParameter("prix"));
		CategoriePizza categorie = CategoriePizza.valueOf(req.getParameter("categorie"));
		Pizza nouvellePizza = new Pizza(code, nom, prix, categorie);
		nouvellePizza.setUrlImage(nom + ".jpg");
		StockagePizzaJpa pizza = new StockagePizzaJpa();
		try {
			pizza.save(nouvellePizza);
			resp.getWriter().write("Pizza ajouter avec succes");
			resp.setStatus(201);
		} catch (ServiceException e) {
			resp.setStatus(500);
			resp.getWriter().write("Code pizza déjà exsistant");
		}

		resp.sendRedirect(req.getContextPath() + "/listPizza");
	}

}
