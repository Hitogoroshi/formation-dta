package dta;

import java.io.IOException;
import java.util.Collection;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.pizzeria.EJB.PizzaServiceEJB;
import fr.pizzeria.exception.ServiceException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

@WebServlet("/editPizza")
public class EditPizzaController extends HttpServlet {

	@EJB
	private PizzaServiceEJB stockagePizza;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/editPizza.jsp");

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

		resp.setCharacterEncoding("UTF-8");
		String ancienCode = req.getParameter("code");
		String newcode = req.getParameter("newcode");
		String nom = req.getParameter("nom");
		double prix = Double.valueOf(req.getParameter("prix"));
		CategoriePizza categorie = CategoriePizza.valueOf(req.getParameter("categorie"));
		Pizza nouvellePizza = new Pizza(newcode, nom, prix, categorie);
		nouvellePizza.setUrlImage(nom + ".jpg");
		try {
			stockagePizza.update(nouvellePizza, ancienCode);
			resp.getWriter().write("Pizza modifier avec succes");
			resp.setStatus(201);
		} catch (ServiceException e) {
			resp.setStatus(500);
			resp.getWriter().write("Code pizza déjà exsistant");
		}

		resp.sendRedirect(req.getContextPath() + "/listPizza");
	}

}
