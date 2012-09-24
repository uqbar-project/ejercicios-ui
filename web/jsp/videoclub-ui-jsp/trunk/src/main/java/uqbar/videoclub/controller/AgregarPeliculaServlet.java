package uqbar.videoclub.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tadp.blocbaster.daos.Videoclub;
import tadp.blocbaster.entidades.Pedido;
import tadp.blocbaster.entidades.Pelicula;
import tadp.blocbaster.exceptions.BusinessException;

@SuppressWarnings("serial")
public class AgregarPeliculaServlet extends WorkflowVideoclubServlet {

	/**
	 * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
	 * methods.
	 * 
	 * @param request
	 *            servlet request
	 * @param response
	 *            servlet response
	 */
	public void executeTask(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Pedido pedido = (Pedido) request.getSession().getAttribute("pedido");
		String idPelicula = request.getParameter("idPeliculaAlquilar");
		if (idPelicula == null || idPelicula.equals("")) {
			throw new BusinessException("Debe seleccionar la película a alquilar");
		}
		Pelicula pelicula = Videoclub.getInstance().getHome(Pelicula.class).searchById(new Integer(idPelicula));
		pedido.addPelicula(pelicula);
		request.getSession().setAttribute("pedido", pedido);
		response.sendRedirect("peliculas/NuevoPedido1.jsp");
	}

}
