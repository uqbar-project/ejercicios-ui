package uqbar.celulares.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.uqbar.commons.model.UserException;
import org.uqbar.edu.paiu.examples.celulares.dao.RepositorioModelos;
import org.uqbar.edu.paiu.examples.celulares.domain.Celular;
import org.uqbar.edu.paiu.examples.celulares.domain.ModeloCelular;

/**
 * Servlet implementation class CelularServlet
 */
public class CelularServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mensaje = "ok";
		try {
			String nombre = request.getParameter("nombre");
			Integer numero = null;
			String parameterNumero = request.getParameter("numero");
			if (parameterNumero != null && !parameterNumero.equals("")) {
				numero = new Integer(parameterNumero);
			}
			ModeloCelular modelo = null;
			String descripcionModelo = request.getParameter("modelo");
			if (descripcionModelo != null && !descripcionModelo.equals("")) {
				modelo = RepositorioModelos.getInstance().get(descripcionModelo);
			}
			Celular celular = new Celular(nombre, numero, modelo, false);
			celular.validar();
		} catch (NumberFormatException e) {
			// Error propio del adapter / controller
			mensaje = "El número de teléfono no debe contener caracteres";
		} catch (UserException e) {
			mensaje = e.getMessage();
		} catch (Exception e) {
			e.printStackTrace();
			mensaje = "Ocurrió un error, consulte al administrador";
		}
		// Manejar la navegación, forwardeando el pedido al jsp con
		// el resultado generado
		// response.setCharacterEncoding("UTF-8");
		request.setAttribute("message", mensaje);
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

}
