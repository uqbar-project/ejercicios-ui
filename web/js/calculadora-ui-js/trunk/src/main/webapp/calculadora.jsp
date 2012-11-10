<%@ page pageEncoding="UTF-8" %> 
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
				var op1 = get("op1");
				var op2 = get("op2");
				document.getElementById("resultado").innerHTML = "<font color=red>" + (op1 + op2) + "</font>";
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
		<form>
			Ingrese un valor: <input id="op1" type="text" onkeyup="actualizarEstado()"> <br>
			Ingrese otro valor: <input id="op2" onkeyup="actualizarEstado()" type="text"> <br>
			<input type="button" id="sumar" value="Sumar" disabled="true" onClick="calcular();" >
			<span id="resultado">
			</span>
		</form>
		</center>
	</body>
</html>
