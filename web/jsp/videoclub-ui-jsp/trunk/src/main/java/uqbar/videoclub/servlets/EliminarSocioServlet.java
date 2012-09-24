package uqbar.videoclub.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.uqbar.commons.model.Home;

import tadp.blocbaster.daos.Videoclub;
import tadp.blocbaster.entidades.Socio;
import tadp.blocbaster.exceptions.BusinessException;

@SuppressWarnings("serial")
public class EliminarSocioServlet extends WorkflowVideoclubServlet {

	/**
	 * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
	 * methods.
	 * 
	 * @param request
	 *            servlet request
	 * @param response
	 *            servlet response
	 * @throws IOException 
	 */
	public void executeTask(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Home<Socio> homeSocios = Videoclub.getInstance().getHome(Socio.class);
		String idSocioAEliminar = request.getParameter("idSocioSeleccionado");
		if (idSocioAEliminar == null) {
			throw new BusinessException("No seleccionó un socio a eliminar");
		}
		Socio socioAEliminar = homeSocios.searchById(new Integer(idSocioAEliminar));
		homeSocios.delete(socioAEliminar);
		response.sendRedirect("./BuscarSocioServlet");
	}

}
