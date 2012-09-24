package uqbar.videoclub.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tadp.blocbaster.daos.Videoclub;
import tadp.blocbaster.entidades.Pedido;
import tadp.blocbaster.entidades.Socio;

public class NuevoPedidoServlet extends WorkflowVideoclubServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1869907992426040015L;

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
		response.setContentType("text/html;charset=UTF-8");
		HttpSession session = request.getSession();
		if (request.getParameter("idSocioSeleccionado") != null) {
			session.setAttribute("idSocio", request.getParameter("idSocioSeleccionado"));
			Integer idSocio = new Integer((String) session.getAttribute("idSocio"));
			Socio socio = Videoclub.getInstance().getHome(Socio.class).searchById(idSocio);
			session.setAttribute("socio", socio);
		}

		session.setAttribute("pedido", new Pedido());
		response.sendRedirect("peliculas/NuevoPedido1.jsp");
	}

}
