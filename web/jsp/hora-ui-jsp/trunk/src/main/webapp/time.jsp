<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Hora actual</title>
</head>
<body>
	<h2><%=new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date()) %></h2>
	<form method="post" action="index.jsp">
		<input type="submit" value="Volver">
	</form>
</body>
</html>