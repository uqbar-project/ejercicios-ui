package com.uqbar.edu.progui.examples.jsp;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DetalleServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Libro libro = Biblioteca.getInstance().getLibro(id);
		request.setAttribute("libro", libro);

		String titulo = request.getParameter("busqueda");
		List<Libro> libros = Biblioteca.getInstance().buscar(titulo);
		int posicionEnLaLista = libros.indexOf(libro);

		if (posicionEnLaLista > 0) {
			request.setAttribute("idAnterior", libros.get(posicionEnLaLista - 1).getId());
		}
		if (posicionEnLaLista < libros.size() - 1) {
			request.setAttribute("idSiguiente", libros.get(posicionEnLaLista + 1).getId());
		}

		request.getRequestDispatcher("detalle.jsp").forward(request, response);
	}
}
