package dta;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SessionFilter implements Filter {

	private static final String[] CHEMIN_SANS_AUTH = { "/login", "/dist", "Images", "style.css" };

	@Override
	public void init(FilterConfig config) throws ServletException {
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest httpReq = (HttpServletRequest) req;
		HttpServletResponse httpResp = (HttpServletResponse) resp;

		Boolean isConnected = (Boolean) httpReq.getSession().getAttribute("isConnected");

		boolean isUrlSansAuth = Arrays.asList(CHEMIN_SANS_AUTH).stream()
				.anyMatch(chemin -> httpReq.getRequestURI().contains(chemin));

		if (isConnected != null || isUrlSansAuth) {
			chain.doFilter(req, resp);
		} else {
			httpResp.sendRedirect(httpReq.getContextPath() + "/login");
		}

	}

	@Override
	public void destroy() {
	}
}
