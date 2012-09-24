<%@ page isELIgnored ="false" pageEncoding="UTF-8" %> 
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<?xml version='1.0' encoding='UTF-8'?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd" >
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<META HTTP-EQUIV="Content-Type" CONTENT="text/html; charset=UTF-8" />
		<title>Calculadora - ejemplo Javascript</title>
		<link rel="stylesheet" type="text/css" href="styles.css" />

		<script language="javascript">
			function get(param) {
				return parseFloat(document.getElementById(param).value);
			}

			function calcular() {
				var op1 = parseFloat(document.getElementById("op1").value);
				var op2 = parseFloat(document.getElementById("op2").value);
				document.getElementById("resultado").innerHTML = op1 + op2;
			}
			
			function actualizarEstado() {
				var op1 = isNaN(get("op1"));
				var op2 = isNaN(get("op2"));
				document.getElementById("sumar").disabled = (op1 || op2);
			}
		</script>
	</head>

	<body>
		<center>
		<h2>Calculadora</h2>
		<form method="post" action="search">
			Ingrese un valor: <input id="op1" type="text" onkeyup="javascript:actualizarEstado();"> <br>
			Ingrese otro valor: <input id="op2" onkeyup="javascript:actualizarEstado();" type="text"> <br>
			<input type="button" id="sumar" value="Sumar" disabled="true" onClick="javascript:calcular();" >
			<span id="resultado" />
		</form>
		</center>
	</body>
</html>
