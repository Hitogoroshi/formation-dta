package dta;

import java.io.IOException;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.pizzeria.exception.ServiceException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;
import fr.pizzeria.service.Stockage;
import fr.pizzeria.service.StockagePizzaJpa;

public class MaServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Stockage<Pizza, String> stockagePizza = new StockagePizzaJpa();
		Collection<Pizza> listpizza = stockagePizza.findAll();

		listpizza.forEach(p -> {
			try {
				resp.getWriter().write(p.toString());
			} catch (IOException e) {
				e.printStackTrace();
				Logger.getGlobal().log(Level.SEVERE, "erreur lors de la récupération des pizzas", e);
				resp.setStatus(500);
			}
		});

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
	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		/*
		 * BufferedReader buffer = new BufferedReader(new
		 * InputStreamReader(req.getInputStream())); String data =
		 * buffer.readLine();
		 * 
		 * String[] coupure1 = data.split("=");
		 * 
		 * try { pizza.update(nouvellePizza, ancienCode);
		 * resp.getWriter().write("Pizza modifier avec succes"); } catch
		 * (ServiceException e) { resp.setStatus(500);
		 * resp.getWriter().write("Code pizza non exsistant"); }
		 */
	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setCharacterEncoding("UTF-8");
		String code = req.getParameter("code");
		StockagePizzaJpa pizza = new StockagePizzaJpa();
		try {
			pizza.delete(code);
			resp.getWriter().write("Pizza supprimer avec succes");
		} catch (ServiceException e) {
			resp.setStatus(500);
			resp.getWriter().write("Code pizza non exsistant");
		}
	}

}
