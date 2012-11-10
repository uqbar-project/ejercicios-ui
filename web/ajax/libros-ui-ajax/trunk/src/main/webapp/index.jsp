<%@ page isELIgnored ="false" pageEncoding="UTF-8" %> 
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<?xml version='1.0' encoding='UTF-8'?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd" >
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<META HTTP-EQUIV="Content-Type" CONTENT="text/html; charset=UTF-8" />
		<title>Busqueda de libros - ajax</title>
		<link rel="stylesheet" type="text/css" href="styles.css" />

		<script language="javascript"><!--
			var id;
			var ajaxRequest = createAjaxRequest();

			function createAjaxRequest() {
				if (typeof XMLHttpRequest != "undefined") {
					return new XMLHttpRequest();
				} 
				else if (window.ActiveXObject) {
					return new ActiveXObject("Microsoft.XMLHTTP");
				}
			}

			function cambiarLibro(nuevoId, esPrimero, esUltimo) {
				// Sin un objeto que maneje el estado es complicado redirigir al siguiente o al anterior
				// si bien en el request tengo la lista de libros, no es fácil generar un único link que vaya 
				// cambiando con el libro seleccionado, porque esa lista está en el servidor, no en el cliente,
				// salvo que la reciba y la trabaje del lado de javascript.
 				//document.getElementById("linkAnterior").style.display = esPrimero ? "none" : "";
				//document.getElementById("linkSiguiente").style.display = esUltimo ? "none" : "";
				id = nuevoId;
				var url = "detalleLibro?id=" + id;

				ajaxRequest.open("GET", url, true);
				ajaxRequest.onreadystatechange = updateLibro;
				ajaxRequest.send(null);
			}

			function updateLibro() {
			    if (ajaxRequest.readyState == 4) {
			        if (ajaxRequest.status == 200) {
						document.getElementById("libro").innerHTML = ajaxRequest.responseText;
			        }
			        else {
			        	alert("No se pudieron obtener los detalles del libro " + id + "\n" + 
			        	      "Por un error: " + ajaxRequest.status + ajaxRequest.statusText);
			        }
			    }
			}		
		</script>
	</head>

	<body>
		<center>
		<h2>B&uacute;squeda de libros</h2>
		<form method="post" action="search">
			<input type="text" name="titulo" id="titulo" value="${param.titulo}" />
			<input type="submit" value="Buscar"/>
		</form>
		
		<c:if test="${requestScope.libros != null}" >
			<h2>Respuestas:</h2>
			<table>
				<tr>
					<th>#</th>
					<th>Nombre</th>
				</tr>
				<c:forEach items="${requestScope.libros}" var="libro" varStatus="status">
					<tr>
						<td>${status.count}</td>
						<td><a href="javascript:cambiarLibro(${libro.id}, ${status.first}, ${status.last});">${libro.titulo}</a></td>
				    </tr>
				</c:forEach>
			</table>
		</c:if>

		<div id="libro">
		</div>
		<br><!--
		<a id="linkAnterior" href="" style="display:none;">Anterior</a>
		<a id="linkSiguiente" href="" style="display:none;">Siguiente</a>
		--></center>
		
	</body>
</html>
