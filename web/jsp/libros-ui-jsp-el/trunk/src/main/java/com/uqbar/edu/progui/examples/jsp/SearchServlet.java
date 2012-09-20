package com.uqbar.edu.progui.examples.jsp;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SearchServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
			IOException {

		String titulo = request.getParameter("titulo");
		
		Collection<Libro> libros = Biblioteca.getInstance().buscar(titulo);

		request.getSession().setAttribute("libros", libros);

		request.getRequestDispatcher("index.jsp").forward(request, response);
	}
}
