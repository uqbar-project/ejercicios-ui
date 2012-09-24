<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@page isELIgnored ="false" %> 
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 


<%@page import="java.util.List" %>
<%@page import="tadp.blocbaster.entidades.Socio" %>
<%@page import="tadp.blocbaster.entidades.Pelicula" %>
<%@page import="tadp.blocbaster.daos.SocioDaoColeccionImpl" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd" >
<script language="Javascript">
function limpiar() {
     document.getElementById("nombreBuscar").value = "";
     document.getElementById("direccionBuscar").value = "";
}

function nuevo() {
    document.listaSocios.action = "NuevoSocioServlet";
    document.listaSocios.submit();
}

function modificar(idSocio) {
    document.getElementById("idSocioSeleccionado").value = idSocio;
    document.listaSocios.action = "EdicionSocioServlet";
    document.listaSocios.submit();
}

function eliminar(idSocio) {
    document.getElementById("idSocioSeleccionado").value = idSocio;
    document.listaSocios.action = "EliminarSocioServlet";
    document.listaSocios.submit();
}

function alquilar(idSocio) {
    document.getElementById("idSocioSeleccionado").value = idSocio;
    document.listaSocios.action = "NuevoPedidoServlet";
    document.listaSocios.submit();
}
</script>


<%@page import="java.util.ArrayList"%><html>
    <head>
        <link rel="stylesheet" type="text/css" href="Styles/cs_basic.css" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Actualización de Socios</title>
    </head>
    <body>
        <table width="80%">
            <tr>
                <td>
                    <image src="Images/videoclub.jpg"/>
                </td>
                <td>
                    <h1>Actualización de Socios</h1>
                </td>
            </tr>
        </table>
        
        <form name="listaSocios" action="BuscarSocioServlet" method="post">
            <table width="80%">
                <tr>
                    <td align="right">Nombre contiene:</td>
                    <td align="left">
                        <input type="text" id="nombreBuscar" name="nombreBuscar" value="${nombreBuscar}"/>
                    </td>
                </tr>
                <tr>
                    <td align="right">Dirección contiene:</td>
                    <td align="left">
                        <input type="text" id="direccionBuscar" name="direccionBuscar" size="35" value="${direccionBuscar}" />
                    </td>
                </tr>
                <tr>
                    <td height="20"></td>
                </tr>
                <tr>
                    <td colspan="2" align="center">
                        <input type="submit" style="cursor:hand" value="Buscar"/>
                        <input type="button" style="cursor:hand" value="Limpiar" onclick="javascript:limpiar();"/>
                        <input type="button" style="cursor:hand" value="Nuevo Socio" onclick="javascript:nuevo();"/>
                    </td>
                </tr>
            </table>
            <br/>
            <table id="main" width="80%">
                <th width="40%">Nombre completo</th>
                <th width="40%">Dirección</th>
                <th width="6%"/>
                <th width="6%"/>
                <th width="8%"/>

                <c:forEach var="socio" items="${socios}">
                <tr width="100%"> 
                    <td width="40%">
                        <c:out value="${socio.nombre}" />
                    </td> 
                    <td width="40%">
                        <c:out value="${socio.direccion}" />
                    </td> 
                    <td>
                        <image src="Images/save.gif" style="cursor:hand" alt="modificar datos del socio ${socio.nombre}" onclick="javascript:modificar('${socio.id}');"/>
                    </td>
                    <td>
                        <image src="Images/delete.gif" style="cursor:hand" alt="eliminar el socio ${socio.nombre}" onclick="javascript:eliminar('${socio.id}');"/>
                    </td>
                    <td>
                        <image src="Images/alquilar.gif" style="cursor:hand" alt="alquilar películas para ${socio.nombre}" onclick="javascript:alquilar('${socio.id}');"/>
                    </td>                    
                </tr>
                </c:forEach>
            </table>
            <input type="hidden" id="idSocioSeleccionado" name="idSocioSeleccionado"/>
            <input type="hidden" id="modo" name="modo"/>
        </form>
    </body>
</html>
