package dta;

import java.io.IOException;
import java.util.Calendar;

import javax.ejb.EJB;
import javax.enterprise.event.Event;
import javax.inject.Inject;
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

@WebServlet("/newpizza")
public class NouvellePizzaController extends HttpServlet {

	@EJB
	private PizzaServiceEJB stockagePizza;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/newpizza.jsp");
		dispatcher.forward(req, resp);

	}

	@Inject
	private Event<CreerPizzaEvent> creerEvent;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setCharacterEncoding("UTF-8");
		String code = req.getParameter("code");
		String nom = req.getParameter("nom");
		double prix = Double.valueOf(req.getParameter("prix"));
		CategoriePizza categorie = CategoriePizza.valueOf(req.getParameter("categorie"));
		Pizza nouvellePizza = new Pizza(code, nom, prix, categorie);
		nouvellePizza.setUrlImage(nom + ".jpg");
		try {
			stockagePizza.save(nouvellePizza);
			CreerPizzaEvent creerPizzaEvent = new CreerPizzaEvent(nouvellePizza, Calendar.getInstance());
			creerEvent.fire(creerPizzaEvent);
			resp.getWriter().write("Pizza ajouter avec succes");
			resp.setStatus(201);
		} catch (ServiceException e) {
			resp.setStatus(500);
			resp.getWriter().write("Code pizza déjà exsistant");
		}

		resp.sendRedirect(req.getContextPath() + "/listPizza");
	}

}
