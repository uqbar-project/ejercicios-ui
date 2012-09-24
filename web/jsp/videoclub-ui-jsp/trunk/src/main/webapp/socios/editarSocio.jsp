<%@page import="tadp.blocbaster.daos.Videoclub"%>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@page isELIgnored ="false" %> 
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@page import="tadp.blocbaster.entidades.Socio" %>
<%@page import="tadp.blocbaster.daos.SocioDaoColeccionImpl" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<script language="Javascript">
function aceptar() {
    if (document.getElementById("nombre").value == "") {
        alert("Debe ingresar nombre");
        return;
    }
    if (document.getElementById("direccion").value == "") {
        alert("Debe ingresar dirección");
        return;
    }
    document.editarSocio.action = "ActualizarSocioServlet";
    document.editarSocio.submit();
}

function cancelar() {
	document.getElementById("nombre").value = "";
	document.getElementById("direccion").value = "";
    editarSocio.action = "./BuscarSocioServlet";
    editarSocio.submit();
}
</script>


<%@page import="tadp.blocbaster.daos.Videoclub"%><html>
    <head>
        <link rel="stylesheet" type="text/css" href="Styles/cs_basic.css" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><c:out value="${titulo}"/></title>
    </head>
    <body>
        <table width="80%">
            <tr>
                <td>
                    <img src="Images/videoclub.jpg" />
                </td>
                <td>
                    <h1><c:out value="${titulo}"/></h1>
                </td>
            </tr>
        </table>
        
        <form name="editarSocio" action="editarSocio.jsp" method="post">
            <table width="80%">
                <tr>
                    <td align="right">Nombre:</td>
                    <td align="left">
                        <input type="text" id="nombre" name="nombre" value="${socio.nombre}"/>
                    </td>
                </tr>
                <tr>
                    <td align="right">Direccion:</td>
                    <td align="left">
                        <input type="text" id="direccion" name="direccion" size="35" value="${socio.direccion}"/>
                    </td>
                </tr>
                <tr>
                    <td height="20"></td>
                </tr>
                <tr>
                    <td colspan="2" align="center">
                        <input type="button" value="Aceptar" style="cursor:hand" onclick="javascript:aceptar();"/>
                        <input type="button" value="Cancelar" style="cursor:hand" onclick="javascript:cancelar();"/>
                    </td>
                </tr>
            </table>
            <br/>
            <input type="hidden" id="nombreBuscar" name="nombreBuscar" value="${nombreBuscar}"/>
            <input type="hidden" id="direccionBuscar" name="direccionBuscar" value="${direccionBuscar}" />
            <input type="hidden" id="idSocioSeleccionado" name="idSocioSeleccionado" value="${idSocioSeleccionado}"/>
            <input type="hidden" id="modo" name="modo" value="${modo}"/>
        </form>
    </body>
</html>
