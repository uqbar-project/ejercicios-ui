package uqbar.busquedaLibros.ajax.mvc.controller;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import uqbar.busquedaLibros.ajax.mvc.applicationModel.BuscadorLibros;

@SuppressWarnings("serial")
public abstract class BaseServlet extends HttpServlet {

	public BaseServlet() {
		super();
	}

	protected BuscadorLibros getBuscador(HttpServletRequest request) {
		BuscadorLibros buscador = (BuscadorLibros) request.getSession().getAttribute("buscador");
	
		if (buscador == null) {
			buscador = new BuscadorLibros();
			request.getSession().setAttribute("buscador", buscador);
		}
	
		return buscador;
	}

}