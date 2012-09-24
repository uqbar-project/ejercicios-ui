package uqbar.busquedaLibros.rest.controller;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import uqbar.busquedaLibros.rest.domain.Biblioteca;
import uqbar.busquedaLibros.rest.domain.Libro;

@SuppressWarnings("serial")
public class SearchServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,
			IOException {

		String titulo = request.getParameter("titulo");

		Collection<Libro> libros = Biblioteca.getInstance().buscar(titulo);
		
		request.setAttribute("libros", libros);
		
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}
}
