package uqbar.videoclub.util;

import javax.servlet.http.HttpServletRequest;
import tadp.blocbaster.entidades.Socio;

public class BusquedaSocioUtil {

	// TODO: abstraer nombreBuscar, direccionBuscar y socioBusqueda que están en
	// la JSP repetidos

	public static Socio getSocio(HttpServletRequest request) {
		String nombre = request.getParameter("nombreBuscar");
		String direccion = request.getParameter("direccionBuscar");
		request.setAttribute("nombreBuscar", nombre != null ? nombre : "");
		request.setAttribute("direccionBuscar", direccion != null ? direccion : "");
		Socio socioBusqueda = new Socio(nombre, direccion);
		return socioBusqueda;
	}

}
