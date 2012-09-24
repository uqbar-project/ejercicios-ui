package uqbar.busquedaLibros.ajax.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import uqbar.busquedaLibros.ajax.domain.Biblioteca;
import uqbar.busquedaLibros.ajax.domain.Libro;

@SuppressWarnings("serial")
public class DetalleServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Libro libro = Biblioteca.getInstance().getLibro(id);
		request.setAttribute("libro", libro);
		request.getRequestDispatcher("detalle.jsp").forward(request, response);
	}
}
