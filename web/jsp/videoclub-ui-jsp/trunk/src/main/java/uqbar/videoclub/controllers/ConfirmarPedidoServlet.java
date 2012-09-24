package uqbar.videoclub.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tadp.blocbaster.entidades.Pedido;
import tadp.blocbaster.entidades.Socio;
import tadp.blocbaster.entidades.mediosDePago.MedioDePago;
import tadp.blocbaster.exceptions.BusinessException;
import uqbar.videoclub.util.MedioPagoUtil;

@SuppressWarnings("serial")
public class ConfirmarPedidoServlet extends WorkflowVideoclubServlet {

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

		// Actualizo el medio de pago para el pedido
		Pedido pedido = (Pedido) request.getSession().getAttribute("pedido");
		MedioDePago medioDePago = new MedioPagoUtil().getMedioPago(request.getParameter("idMedioPago"));
		if (medioDePago == null) {
			throw new BusinessException("Debe ingresar medio de pago");
		}
		pedido.setMedioDePago(medioDePago);
		request.getSession().setAttribute("pedido", pedido);

		// Agrego el pedido al socio
		Socio socio = (Socio) request.getSession().getAttribute("socio");
		socio.addPedido(pedido);
		request.getSession().setAttribute("socio", socio);

		response.sendRedirect("peliculas/NuevoPedido3.jsp");
	}

}
