package uqbar.videoclub.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tadp.blocbaster.entidades.Socio;

public class NuevaBusquedaServlet extends WorkflowVideoclubServlet {

	private static final long serialVersionUID = 1L;

	@Override
	public void executeTask(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("nombreBuscar", "");
		request.setAttribute("direccionBuscar", "");
		request.setAttribute("socios", new ArrayList<Socio>());

		request.getRequestDispatcher("socios/listaSocios.jsp").forward(request, response);
	}
	
}
