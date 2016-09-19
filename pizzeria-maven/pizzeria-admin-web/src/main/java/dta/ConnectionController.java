package dta;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class ConnectionController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/login.jsp");
		dispatcher.forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setCharacterEncoding("UTF-8");
		String login = req.getParameter("login");
		String motDePasse = req.getParameter("motDePasse");

		if (login.equals("admin@pizzeria.fr") && motDePasse.equals("admin")) {

			resp.sendRedirect(req.getContextPath() + "/listPizza");
			HttpSession session = req.getSession();
			session.setAttribute("isConnected", true);

		} else {
			resp.sendRedirect(req.getContextPath() + "/login");
		}
	}

}
