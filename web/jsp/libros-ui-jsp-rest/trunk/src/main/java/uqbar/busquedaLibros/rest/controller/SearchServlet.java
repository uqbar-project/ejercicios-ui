package uqbar.busquedaLibros.rest.controller;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import uqbar.libros.domain.Biblioteca;
import uqbar.libros.domain.Libro;

@SuppressWarnings("serial")
public class SearchServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Adapta los parámetros del request
		String titulo = request.getParameter("titulo");
		
		// Delegar en los objetos que efectivamente procesan el pedido
		// Esos objetos pueden ser de dominio, de aplicación (app model), homes, etc.
		Collection<Libro> libros = Biblioteca.getInstance().buscar(titulo);
		
		// Guardo el estado que quiero comunicar a la vista
		request.setAttribute("libros", libros);
		
		// Delego a la vista
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}
}
