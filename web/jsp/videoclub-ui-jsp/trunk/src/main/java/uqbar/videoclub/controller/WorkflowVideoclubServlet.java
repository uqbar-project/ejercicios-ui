package uqbar.videoclub.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.uqbar.commons.model.UserException;

import tadp.blocbaster.exceptions.BusinessException;

/**
 * Servlet implementation class WorkflowVideoclubServlet
 */
public abstract class WorkflowVideoclubServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Handles the HTTP <code>GET</code> method.
	 * 
	 * @param request
	 *            servlet request
	 * @param response
	 *            servlet response
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.processRequest(request, response);
	}

	private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			this.executeTask(request, response);
		} catch (BusinessException e) {
			this.mostrarError(request, response, e.getMessage());
		} catch (UserException e) {
			this.mostrarError(request, response, e.getMessage());
		}

	}

	public abstract void executeTask(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;

	/**
	 * Handles the HTTP <code>POST</code> method.
	 * 
	 * @param request
	 *            servlet request
	 * @param response
	 *            servlet response
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.processRequest(request, response);
	}

	/**
	 * Permite disparar un mensaje de error
	 * 
	 * @param request
	 * @param response
	 * @param mensaje
	 * @throws IOException
	 */
	public void mostrarError(HttpServletRequest request, HttpServletResponse response, String mensaje) throws IOException {
		request.getSession().setAttribute("mensaje", mensaje);
		response.sendRedirect("error/error.jsp");
	}

}
