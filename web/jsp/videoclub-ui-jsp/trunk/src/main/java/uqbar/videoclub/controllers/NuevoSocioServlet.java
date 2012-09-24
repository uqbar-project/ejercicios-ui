package uqbar.videoclub.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tadp.blocbaster.entidades.Socio;

public class NuevoSocioServlet extends EdicionSocioServlet {

	private static final long serialVersionUID = 1L;

	public void prepareExecuteTask(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("modo", "A");
		request.setAttribute("socio", new Socio());
		request.setAttribute("titulo", "Nuevo Socio");
		request.setAttribute("idSocioSeleccionado", "");
	}

}
