package uqbar.videoclub.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tadp.blocbaster.daos.Videoclub;
import tadp.blocbaster.entidades.Socio;
import uqbar.videoclub.util.BusquedaSocioUtil;

@SuppressWarnings("serial")
public class BuscarSocioServlet extends WorkflowVideoclubServlet {

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
		Socio socioBusqueda = BusquedaSocioUtil.getSocio(request);
		List<Socio> socios = Videoclub.getInstance().getHome(Socio.class).searchByExample(socioBusqueda);
		request.setAttribute("socios", socios);

		response.setCharacterEncoding("UTF-8");
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/socios/listaSocios.jsp");
		dispatcher.include(request, response);
	}

}
