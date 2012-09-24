<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<jsp:useBean id="pedido" class="tadp.blocbaster.entidades.Pedido" scope="session" />
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <link rel="stylesheet" type="text/css" href="../Styles/cs_basic.css" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Carrito</title>
    </head>
    <body>
        <table id="main" width="100%">
            <tr>
                <td colspan="2" align="center">
                    <image src="../Images/carrito.jpg" height="150" width="150"/>
                </td>
            </tr>
            <tr>
                <th align="right">
                    Total:
                </th>
                <th align="right">
                    <fmt:formatNumber value="${pedido.costo}" type="currency"/>
                </th>
            </tr>
        </table>
        <br/>
        <table id="gris" border="1" width="100%" cellpadding="2" cellspacing="2">
            <th>
                Películas que lleva:
            </th>
            <th>
                Director
            </th>
            <c:forEach var="pelicula" items="${pedido.peliculasParaAlquilar}">
                <tr>
                    <td>
                        <c:out value="${pelicula.nombre}"/>
                    </td>
                    <td>
                        <c:out value="${pelicula.director}"/>
                </td>                
            </tr>
            </c:forEach>
        </table>
    </body>
</html>
