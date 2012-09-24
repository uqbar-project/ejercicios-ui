package uqbar.busquedaLibros.ajax.mvc.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class DetalleServlet extends BaseServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int posicion = Integer.parseInt(request.getParameter("posicion"));

		this.getBuscador(request).elegirLibro(posicion);
		
		request.getRequestDispatcher("detalle.jsp").forward(request, response);
	}
}
