<%@ page isELIgnored ="false" pageEncoding="UTF-8" %> 
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<?xml version='1.0' encoding='UTF-8'?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd" >
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<META HTTP-EQUIV="Content-Type" CONTENT="text/html; charset=UTF-8" />
		<title>Calculadora con evaluación dinámica - ejemplo javascript</title>
		<link rel="stylesheet" type="text/css" href="styles.css" />

		<script language="javascript">
			function get(param) {
				return getWidget(param).value;
			}
			
			function getWidget(param) {
				return document.getElementById(param);
			}

			function calcula(operacion) {
				var operando1 = get("op1");
				var operando2 = get("op2");
				var result = eval(operando1 + operacion + operando2); 
				getWidget("resultado").innerHTML = result;
			}
			
			function actualizarEstado() {
				// TODO: Evitar que con strings vacíos me habilite los botones
				var op1 = isNaN(get("op1"));
				var op2 = isNaN(get("op2"));
				var inhabilitado = (op1 || op2);
				getWidget("suma").disabled = inhabilitado;
				getWidget("resta").disabled = inhabilitado;
				getWidget("multiplicacion").disabled = inhabilitado;
				getWidget("division").disabled = inhabilitado || get("op2") == 0;
			}
		</script>
	</head>

	<body>
		<center>
		<h2>Calculadora</h2>
		<form method="post" action="search">
			Ingrese un valor: <input id="op1" type="text" onkeyup="javascript:actualizarEstado();"> <br>
			Ingrese otro valor: <input id="op2" onkeyup="javascript:actualizarEstado();" type="text"> <br>
			<input type="button" id="suma" value=" + " onclick="calcula('+')" disabled="true"/> 
			<input type="button" id="resta" value=" - " onclick="calcula('-')" disabled="true"/> 
			<input type="button" id="multiplicacion" value=" x " onclick="calcula('*')" disabled="true"/> 
			<input type="button" id="division" value=" : " onclick="calcula('/')" disabled="true"/> 
			<span id="resultado" />
		</form>
		</center>
	</body>
</html>
