<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@page import="tadp.blocbaster.entidades.Socio"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<script language="Javascript">
function cargarPedidoNuevo() {
    document.NuevoPedido3.action = '../NuevoPedidoServlet';
    document.NuevoPedido3.submit();
}

function listaSocios() {
    document.NuevoPedido3.action = '../NuevaBusquedaServlet';
    document.NuevoPedido3.submit();
}
</script>
   <html>
    <head>
        <link rel="stylesheet" type="text/css" href="../Styles/cs_basic.css" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Nuevo pedido - paso 3 de 3</title>
    </head>
    <body>
        <table width="100%" height="100%">
            <tr>
                <td>
                    <image src="../Images/videoclub.jpg"/>
                </td>
                <td>
                    <h1>Nuevo pedido - Paso 3 de 3</h1>
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <iframe width="30%" frameborder="1" height="580px" src="Carrito.jsp" marginwidth="20px" title="Carrito">
                    </iframe>
                    <iframe width="67%" frameborder="1" height="580px" src="MedioPagoElegido.jsp" marginwidth="20px" title="Medio de Pago">
                    </iframe>
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <table width="100%" height="50px" bgcolor="#FFFFCC">
                        <tr>
                            <td align="center"><b>Socio:</b>
                                <%= ((Socio) session.getAttribute("socio")).toString() %>
                            </td>
                            <td align="center">
                                <input type="button" style="cursor:hand" value="Nuevo pedido" onclick="javascript:cargarPedidoNuevo();"/>
                            </td>
                            <td align="center">
                                <input type="button" style="cursor:hand" value="Volver a socios" onclick="javascript:listaSocios();"/>
                            </td>
                        </tr>
                    </table>
                </td>
            </tr>              
        </table>
        <form id="NuevoPedido3" name="NuevoPedido3" method="post">
        </form>
    </body>
</html>
