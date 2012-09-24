package uqbar.videoclub.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.uqbar.commons.model.Home;

import tadp.blocbaster.daos.Videoclub;
import tadp.blocbaster.entidades.Socio;
import tadp.blocbaster.exceptions.BusinessException;

/**
 * @version
 */
@SuppressWarnings("serial")
public class ActualizarSocioServlet extends WorkflowVideoclubServlet {

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
		Home<Socio> socioHome = Videoclub.getInstance().getHome(Socio.class);
		Socio socio;
		if (request.getParameter("modo").equalsIgnoreCase("A")) {
			socio = new Socio();
		} else {
			String idSocioSeleccionado = request.getParameter("idSocioSeleccionado");
			if (idSocioSeleccionado == null || idSocioSeleccionado.equals("")) {
				throw new BusinessException("Debe seleccionar un socio");
			}
			socio = socioHome.searchById(new Integer(idSocioSeleccionado));
		}
		String nombre = request.getParameter(Socio.NOMBRE);
		socio.setNombre(nombre);
		String direccion = request.getParameter(Socio.DIRECCION);
		socio.setDireccion(direccion);

		if (request.getParameter("modo").equalsIgnoreCase("A")) {
			socioHome.create(socio);
		} else {
			socioHome.update(socio);
		}

		response.sendRedirect("./BuscarSocioServlet");
	}

}
