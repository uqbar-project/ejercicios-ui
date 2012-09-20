<%@ page isELIgnored ="false" pageEncoding="UTF-8" %> 
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<?xml version='1.0' encoding='UTF-8'?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd" >
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<META HTTP-EQUIV="Content-Type" CONTENT="text/html; charset=UTF-8" />
		<title>Ejemplo de página html</title>
		<link rel="stylesheet" type="text/css" href="styles.css" />
	</head>

	<body>
		<center>
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
			
			<c:if test="${requestScope.idAnterior != null}">
				<a href="detalleLibro?busqueda=${param.busqueda}&id=${requestScope.idAnterior}">Anterior</a>
			</c:if>					
			<c:if test="${requestScope.idSiguiente != null}">
				<a href="detalleLibro?busqueda=${param.busqueda}&id=${requestScope.idSiguiente}">Siguiente</a>
			</c:if>		

			<br />
			<a href="search?titulo=${param.busqueda}">Volver</a>
		</center>
	</body>
</html>
