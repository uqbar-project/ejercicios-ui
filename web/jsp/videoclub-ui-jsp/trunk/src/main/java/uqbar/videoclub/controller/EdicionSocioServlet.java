package uqbar.videoclub.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tadp.blocbaster.daos.Videoclub;
import tadp.blocbaster.entidades.Socio;
import tadp.blocbaster.exceptions.BusinessException;

public class EdicionSocioServlet extends WorkflowVideoclubServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4197507831147488519L;

	public void executeTask(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		this.prepareExecuteTask(request, response);

		request.setAttribute("nombreBuscar", request.getParameter("nombreBuscar"));
		request.setAttribute("direccionBuscar", request.getParameter("direccionBuscar"));
		request.getRequestDispatcher("./socios/editarSocio.jsp").forward(request, response);
	}

	public void prepareExecuteTask(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("modo", "M");
		request.setAttribute("titulo", "Edición de Socio");
		String idSocio = request.getParameter("idSocioSeleccionado");
		if (idSocio == null || idSocio.equals("")) {
			throw new BusinessException("Debe seleccionar el socio");
		}
		Socio socio = Videoclub.getInstance().getHome(Socio.class).searchById(new Integer(idSocio));
		request.setAttribute("socio", socio);
		request.setAttribute("idSocioSeleccionado", "" + socio.getId());
	}

}
