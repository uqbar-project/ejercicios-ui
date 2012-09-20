<%@ page isELIgnored ="false" pageEncoding="UTF-8" %> 
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<?xml version='1.0' encoding='UTF-8'?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd" >
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title>Detalle de libro seleccionado</title>
		<link rel="stylesheet" type="text/css" href="styles.css" />
	</head>

	<c:set var="libro" scope="page" value="${sessionScope.libros[param.nro]}"/>
	<body>
		<h2>Detalle de libro</h2>
		<table>
			<tr>
				<th>Título</th>
				<td>${libro.titulo}</td>
			</tr>					
			<tr>
				<th>Autor</th>
				<td>${libro.autor}</td>
			</tr>
		</table>
		
		<br />
		<a href="index.jsp">Volver</a>
	</body>
</html>
