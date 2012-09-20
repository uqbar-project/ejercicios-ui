package ar.edu.unq.tpi.labso.calculadora.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ar.edu.unq.tpi.labso.calculadora.domain.Calculadora;

public class CalcularServlet extends HttpServlet {

	private double variableLoca = 0;

	@Override
	protected void doPost(HttpServletRequest request, //
			HttpServletResponse response) //
			throws ServletException, IOException {

		// Adaptar lo que la vista nos da para que el negocio lo reciba
		double arg1 = Double.parseDouble(request.getParameter("arg1"));
		double arg2 = Double.parseDouble(request.getParameter("arg2"));

		// Hablar con los objetos de negocio
		Calculadora calculadora = new Calculadora(arg1, arg2);
		double resultado = calculadora.sumar();

		// Manejar el estado --> usamos como contenedor el scope request
		request.setAttribute("resultado", resultado);

		// Manejar la navegación, forwardeando el pedido al jsp con
		// el resultado generado
		request //
		.getRequestDispatcher("index.jsp").forward(request, response);
	}

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// Originalmente el ejemplo redireccionaba el doGet hacia el doPost
		// this.doPost(request, response);
		// Ahora mostramos cómo se maneja el estado de un servlet
		double arg1 = Double.parseDouble(request.getParameter("arg1"));
		// variableLoca es una variable de acceso compartido por todos los
		// usuarios que hacen peticiones
		this.variableLoca++;
		Calculadora calculadora = new Calculadora(arg1, this.variableLoca);
		double resultado = calculadora.sumar();

		request.setAttribute("resultado", resultado);
		request //
		.getRequestDispatcher("index.jsp").forward(request, response);
	}
}
