<?xml version='1.0' encoding='UTF-8'?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd" >

<%@ page isELIgnored ="false" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<META HTTP-EQUIV="Content-Type" CONTENT="text/html; charset=UTF-8" />
	<title>Calculadora</title>
	<link rel="stylesheet" type="text/css" href="styles.css" />
</head>

<body>
<h2>Calculadora</h2>

<form method="post" action="calcular">
	Ingrese un número:
	<input type="text" name="arg1" value="${param.arg1}"/>
	<br/>
	
	Otro:
	<input type="text" name="arg2" value="${param.arg2}"/>
	<br/>
	
	<input type="submit" value="Sumar" />	
</form>

<% if (request.getAttribute("resultado") != null) { // abro%>
	<p>El resultado es ${resultado}</p>
<% } // cierro %>

</body>
</html>
