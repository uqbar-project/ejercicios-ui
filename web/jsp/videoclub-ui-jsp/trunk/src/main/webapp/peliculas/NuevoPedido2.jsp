<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@page import="tadp.blocbaster.daos.SocioDaoColeccionImpl"%>
<%@page import="tadp.blocbaster.entidades.Socio"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<script language="Javascript">
function anterior() {
    document.NuevoPedido2.action = 'NuevoPedido1.jsp';
    document.NuevoPedido2.submit();
}

function confirmar() {
    formMedioPago = frames['MedioPago'].document;
    if (formMedioPago.getElementById("datosAdicionales").style.visibility == "visible" && formMedioPago.getElementById("numeroTarjeta").value == "") {
        alert("Debe ingresar un número de tarjeta");
        return;
    }
    document.getElementById("idMedioPago").value = formMedioPago.getElementById("medioPago").value;
    document.getElementById("numeroTarjeta").value = formMedioPago.getElementById("numeroTarjeta").value;
    document.NuevoPedido2.action = '../ActualizarMedioPagoServlet';
    document.NuevoPedido2.submit();
}

</script>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="../Styles/cs_basic.css" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Nuevo pedido - paso 2 de 3</title>
    </head>
    <body>
        <table width="100%" height="100%">
            <tr>
                <td>
                    <image src="../Images/videoclub.jpg"/>
                </td>
                <td>
                    <h1>Nuevo pedido - Paso 2 de 3</h1>
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <iframe width="30%" frameborder="1" height="580px" src="Carrito.jsp" marginwidth="20px" title="Carrito">
                    </iframe>
                    <iframe width="67%" frameborder="1" height="580px" src="MedioPago.jsp" marginwidth="20px" title="Medio de pago" name="MedioPago" id="MedioPago">
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
                                <input type="button" style="cursor:hand" value="Confirmar Pedido" onclick="javascript:confirmar();"/>
                            </td>
                        </tr>
                    </table>
                </td>
            </tr>              
        </table>
        <form id="NuevoPedido2" name="NuevoPedido2" method="post">
            <input type="hidden" id="idMedioPago" name="idMedioPago">
            <input type="hidden" id="numeroTarjeta" name="numeroTarjeta">
        </form>
    </body>
</html>
