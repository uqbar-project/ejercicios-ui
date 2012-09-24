<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<script language="Javascript">
function mostrarOpciones() {
	// TODO: Utilizar las constantes de MedioPagoUtil
     if (document.getElementById("medioPago").value == "2") {
        document.getElementById("datosAdicionales").style.visibility = "visible";
     } else {
        document.getElementById("datosAdicionales").style.visibility = "hidden";
     }
}

</script>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="../Styles/cs_basic.css" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Medio de pago</title>
    </head>
    <body>
        <form id="Pago" name="Pago" method="post">
            <table width="100%" id="grey" cellspacing="1" cellpadding="1">
                <tr>
                    <td>
                        <h2>Medio de pago</h2>
                    </td>
                    <td colspan="2" align="right">
                        <image src="../Images/dinero.jpeg" height="140" width="140"/>
                    </td>
                </tr>
                <tr>
                    <td align="right">Medio de pago:</td>
                    <td align="left">
                        <select id="medioPago" name="medioPago" onchange="mostrarOpciones();">
                            <option value="1" selected>Efectivo</option>
                            <option value="2">Tarjeta de Crédito</option>
                            <option value="3">Ticket Canasta</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <br/>
                        <br/>
                        <div id="datosAdicionales" width="80%" align="center" style="visibility:hidden;">
                            <table>
                                <tr>
                                    <td align="right">Número de tarjeta:
                                    </td>
                                    <td align="left"><input type="text" id="numeroTarjeta" name="numeroTarjeta" size="20">
                                    </td>
                                </tr>
                            </table>
                        </div>
                    </td>
                </tr>
            </table>
        </form>
    </body>
</html>
