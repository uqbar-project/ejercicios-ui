<%@page import="java.util.Collection"%>
<%@page import="org.uqbar.edu.paiu.examples.celulares.domain.ModeloCelular"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page
	import="org.uqbar.edu.paiu.examples.celulares.dao.RepositorioModelos"%>
<%@ page isELIgnored="false" pageEncoding="UTF-8"%>
<%@ page errorPage="error.jsp" %>

<?xml version='1.0' encoding='UTF-8'?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd" >
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<META HTTP-EQUIV="Content-Type" CONTENT="text/html; charset=UTF-8" />
	<title>Celulares - validaciones</title>
	<link rel="stylesheet" type="text/css" href="styles.css" />
<script language="javascript">
function get(elemento) {
	return document.getElementById(elemento);
}

function validarMultiple() {
	var message = "";
	var numero = get('numero').value;
	if (numero == null || numero == "") {
		message = agregarMensajeError(message, "Debe ingresar número");
	}
	if (isNaN(numero)) {
		message = agregarMensajeError(message, "El número de teléfono no debe contener caracteres");
	}
	if (parseInt(numero) <= 1000) {
		message = agregarMensajeError(message, "El número debe ser mayor a 1000");
	}
	var nombre = get('nombre').value;
	if (nombre == null || nombre == "") {
		message = agregarMensajeError(message, "Debe ingresar nombre");
	}
	var modelo = get('modelo');
	var idModelo = (modelo.options[modelo.selectedIndex].id);
	if (idModelo == -1) {
		message = agregarMensajeError(message, "Debe ingresar modelo de celular");
	}

	if (message != "") {
		get('mensajesError').style.display = "block";
		get('mensajesError').innerHTML = "<ul>" + message + "</ul>";
		get('mensajesOk').style.display = "none";
	} else {
		get('mensajesError').style.display = "none";
		get('mensajesOk').style.display = "block";
		get('mensajesOk').innerHTML = "Formulario validado";
	}
}	

function agregarMensajeError(message, errorMessage) {
	message += "<li>";
	message += errorMessage + "<br>";
	message += "</li>";
	return message;
}

function tipoValidacionSeleccionada() {
	var tipoValidacion = document.celularForm.tipoValidacion;
	for (i = 0 ; i < tipoValidacion.length ; i++){
     	 if (tipoValidacion[i].checked) {
     		 return tipoValidacion[i].value; 
        	 break; 
     	 }
  	} 
}

function validarConExcepcion() {
	var numero = get('numero').value;
	if (numero == null || numero == "") {
		throw "Debe ingresar número";
	}
	if (isNaN(numero)) {
		throw "El número de teléfono no debe contener caracteres";
	}
	if (parseInt(numero) <= 1000) {
		throw "El número debe ser mayor a 1000";
	}
	var nombre = get('nombre').value;
	if (nombre == null || nombre == "") {
		throw "Debe ingresar nombre";
	}
	var modelo = get('modelo');
	// le falta el value a cada option
	var idModelo = (modelo.options[modelo.selectedIndex].id);
	if (idModelo == -1) {
		throw "Debe ingresar modelo de celular";
	}
}	

function validarSimple() {
	try {
		validarConExcepcion();
		get('mensajesError').style.display = "none";
		get('mensajesOk').style.display = "block";
		get('mensajesOk').innerHTML = "Formulario validado";
	} catch (validacion) {
		get('mensajesError').style.display = "block";
		get('mensajesError').innerHTML = "<ul><li>" + validacion + "</li></ul>";
		get('mensajesOk').style.display = "none";
	}
}

function validar() {
	var seleccion = tipoValidacionSeleccionada();
	switch (seleccion) {
	case "1":
		validarMultiple();
		break;
	case "2":
		validarSimple();
		break;
	default:
		document.celularForm.submit();
		break;
	}
}

function procesarValidaciones() {
	var message = get('message').value;
	if (message == null || message == "") {
		get('mensajesError').style.display = "none";
		get('mensajesOk').style.display = "none";
	} else {
		if (message != "ok") {
			get('mensajesError').style.display = "block";
			get('mensajesError').innerHTML = "<ul>" + message + "</ul>";
			get('mensajesOk').style.display = "none";
		} else {
			get('mensajesError').style.display = "none";
			get('mensajesOk').style.display = "block";
			get('mensajesOk').innerHTML = "Formulario validado";
		}
	}
}
</script>

</head>
<body onload="javascript:procesarValidaciones();">
<h2>Alta de un cliente para celulares</h2>
<%
	// A proposito	
	// Object objeto = null;
	//objeto.equals("");
	
	request.setAttribute("paginaOrigen", request.getRequestURI());
	request.setAttribute("modelos", RepositorioModelos.getInstance().getModelos());
	
%>

<div class="info" id="mensajesOk" style="display: none;"></div>
<div class="error" id="mensajesError" style="display: none;"></div>
<form method="post" action="validar" name="celularForm">
<table width="90%">
	<tr>
		<td align="right">N&uacute;mero:</td>
		<td><input type="text" name="numero" id="numero"
			value="${param.numero}" /></td>
	</tr>
	<tr>
		<td align="right">Nombre:</td>
		<td><input type="text" name="nombre" id="nombre"
			value="${param.nombre}" /></td>
	</tr>
	<tr>
		<td align="right">Modelo:</td>
		<td><select name="modelo" id="modelo">
			<option id="-1"></option>
			<c:set var="modeloSeleccionado" value="${param.modelo}"/>
			<c:forEach var="itModelo" items="${modelos}">
				<option id="${itModelo.getDescripcion()}"
					<c:if test="${modeloSeleccionado != null && itModelo.getDescripcion().equals(modeloSeleccionado)}">
						selected="selected" 
					</c:if>
				>
					<c:out value="${itModelo.getDescripcion()}"/>
				</option>
			</c:forEach>
		</select></td>
	</tr>
	<tr>
		<%
			int tipoValidacion = 0;
			if (request.getAttribute("tipoValidacion") != null && !request.getAttribute("tipoValidacion").equals("")) {
				tipoValidacion = new Integer("" + request.getAttribute("tipoValidacion")).intValue();
			}
		   
		%>
		<td align="right" halign="top">Tipo de validaci&oacute;n:</td>
		<td><input type="radio" name="tipoValidacion" value="1" 
			id="tipoValidacion" checked="<%=tipoValidacion == 1%>" />client-side (todos los errores)<br />
		<input type="radio" name="tipoValidacion" value="2"
			id="tipoValidacion" checked="<%=tipoValidacion == 2%>"/>client-side (de a un error)<br />
		<input type="radio" name="tipoValidacion" value="3"
			id="tipoValidacion" checked="<%=tipoValidacion == 3%>"/>server-side</td>
	</tr>
	<tr>
		<td align="center" colspan="2"><br />
		<input type="button" value="Validar" onClick="javascript:validar();" /></td>
		<input type="hidden" id="message" name="message" value="${requestScope.message}"/>
	</tr>
</table>
</form>
</body>
</html>
