<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@page isELIgnored ="false" %> 
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="tadp.blocbaster.daos.SocioDaoColeccionImpl"%>
<%@page import="tadp.blocbaster.entidades.Socio"%>
<%@page import="tadp.blocbaster.entidades.Pedido"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<script language="Javascript">
function anterior() {
    document.NuevoPedido1.action = '../BuscarSocioServlet?nombreBuscar=${socio.nombre}&direccionBuscar=${socio.direccion}';
    document.NuevoPedido1.submit();
}
</script>

<%@page import="tadp.blocbaster.entidades.Socio"%><html>
    <head>
        <link rel="stylesheet" type="text/css" href="../Styles/cs_basic.css" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Nuevo pedido - paso 1 de 3</title>
    </head>
    <body>
        <% 
        Pedido pedido = (Pedido) session.getAttribute("pedido");
        String botonSiguienteVisible = "visible";
        if (pedido.getPeliculasParaAlquilar().isEmpty()) {
            botonSiguienteVisible = "hidden";
        }
        %>
        <form id="NuevoPedido1" name="NuevoPedido1" action="NuevoPedido2.jsp" method="post">
            <table width="100%" height="100%">
                <tr>
                    <td>
                        <image src="../Images/videoclub.jpg"/>
                    </td>
                    <td>
                        <h1>Nuevo pedido - Paso 1 de 3</h1>
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <iframe width="30%" frameborder="1" height="580px" src="Carrito.jsp" marginwidth="20px" title="Carrito">
                        </iframe>
                        <iframe width="67%" frameborder="1" height="580px" src="AgregarPelicula.jsp" marginwidth="20px" title="Agregar Película">
                        </iframe>
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <table width="100%" height="50px" bgcolor="#FFFFCC">
                            <tr>
                                <td align="center">
                                    <input type="button" style="cursor:hand" id="Anterior" value="Anterior" onclick="javascript:anterior();"/>
                                </td>
                                <td align="center"><b>Socio:</b>
                                    <%= ((Socio) session.getAttribute("socio")).toString() %>
                                </td>
                                <td align="center">
                                    <input type="submit" style="cursor:hand" value="Siguiente" style="visibility: <%= botonSiguienteVisible %>;"/>
                                </td>
                            </tr>
                        </table>
                    </td>
                </tr>            
            </table>
            <input type="hidden" id="idPeliculaAlquilar" name="idPeliculaAlquilar"/>
        </form>
    </body>
</html>
