<%@ page isELIgnored ="false" pageEncoding="UTF-8" %> 
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<?xml version='1.0' encoding='UTF-8'?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd" >
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title>Ejemplo de página html</title>
		<link rel="stylesheet" type="text/css" href="styles.css" />
	</head>

	<body>
		<center>
		<h2>Búsqueda de libros</h2>
		<form method="get" action="search">
			<input type="text" name="titulo" value="${param.titulo}" />
			<input type="submit" value="Buscar"/>
		</form>
		
		<c:if test="${requestScope.libros != null}" >
			<h2>Respuestas:</h2>
			<table>
				<tr>
					<th>#</th>
					<th>Nombre</th>
					<th>Autor</th>
				</tr>
				<c:forEach items="${requestScope.libros}" var="libro" varStatus="status">
					<tr>
						<td>${status.count}</td>
						<td><a href="detalleLibro?busqueda=${param.titulo}&id=${libro.id}">${libro.titulo}</a></td>
				    	<td>${libro.autor}</td>
				    </tr>
				</c:forEach>
			</table>
		</c:if> 
		</center>
	</body>
</html>
