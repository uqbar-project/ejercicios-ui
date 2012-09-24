<%@ page isELIgnored ="false" pageEncoding="UTF-8" %> 
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<?xml version='1.0' encoding='UTF-8'?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd" >
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<META HTTP-EQUIV="Content-Type" CONTENT="text/html; charset=UTF-8" />
		<title>Detalle de libro</title>
		<link rel="stylesheet" type="text/css" href="styles.css" />
	</head>

	<body>
		<center>
			<h2>Detalle de libro</h2>
			<table>
				<tr>
					<th>T&iacute;tulo</th>
					<td>${libro.titulo}</td>
				</tr>					
				<tr>
					<th>Autor</th>
					<td>${libro.autor}</td>
				</tr>
			</table>
		</center>
	</body>
</html>
