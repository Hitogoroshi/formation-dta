package dta;

import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;

@Provider
public class AccesJavascriptFiltre implements ContainerResponseFilter {

	@Override
	public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext)
			throws IOException {

		responseContext.getHeaders().add("Access-Control-Allow-Origin", "http://127.0.0.1:8001");
		responseContext.getHeaders().add("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT");
		responseContext.getHeaders().add("Access-Control-Allow-Headers", "origin, content-type, accept, authorization");
		responseContext.getHeaders().add("Access-Control-Allow-Credentials",
				"origin, content-type, accept, authorization");

	}

}
