<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <link rel="stylesheet" type="text/css" href="../Styles/cs_basic.css" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Error en Videoclub</title>
    </head>
    <body>
        
        <table width="80%" align="center">
            <tr>
                <td width="20%" align="right">
                    <image src="../Images/logoError.gif"/>
                </td>
                <td width="10"><br/></td>
                <td width="70%" align="left">
                    <h1><%= session.getAttribute("mensaje") %></h1>
                </td>
            </tr>
            <tr>
                <td>
                    <br/>
                </td>
            </tr>
            <tr>
                <td colspan="3" align="center">
                    <form action="../index.jsp" method="post">
                        <input type="submit" value="Volver a la aplicación">
                    </form> 
                </td>
            </tr>
        </table>        
        
    </body>
</html>
