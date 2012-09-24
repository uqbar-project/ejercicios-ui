<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@page import="tadp.blocbaster.entidades.mediosDePago.Efectivo"%>
<%@page import="tadp.blocbaster.entidades.Pedido"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <link rel="stylesheet" type="text/css" href="../Styles/cs_basic.css" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Medio de pago</title>
    </head>
    <body>
        <% 
        Pedido pedido = (Pedido) request.getSession().getAttribute("pedido");
        %>
        <br>
        <br>
        <table width="100%" cellspacing="1" cellpadding="1">
            <tr>
                <td align="right" width="30%">
                    Medio de pago elegido:
                </td>
                <th width="20%" bgcolor="SteelBlue">
                    <%= pedido.getMedioDePago().toString()%>
                </th>
                <td width="50%">
                </td>
            </tr>
        </table>
        <br>
        <br>
    </body>
</html>
