package dta;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/deconnection")
public class DeconnectionController extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		/* Récupération et destruction de la session en cours */
		HttpSession session = req.getSession();
		session.invalidate();

		resp.sendRedirect(req.getContextPath() + "/login");
	}

}
