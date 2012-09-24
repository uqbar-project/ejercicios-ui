package uqbar.busquedaLibros.ajax.mvc.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class SearchServlet extends BaseServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
			IOException {

		String titulo = request.getParameter("titulo");
		this.getBuscador(request).buscar(titulo);

		request.getRequestDispatcher("index.jsp").forward(request, response);
	}
}
