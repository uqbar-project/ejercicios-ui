<%@page import="tadp.blocbaster.entidades.Pelicula"%>
<%@page import="org.uqbar.commons.model.Home"%>
<%@page import="tadp.blocbaster.daos.Videoclub"%>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<%@page import="java.util.List" %>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
	<script language="javascript">
	function limpiar() {
	     document.getElementById("genero").selectedIndex = -1;
	     document.getElementById("titulo").value = "";
	}
	
	function alquilar(idPelicula) {
	    parent.document.getElementById("idPeliculaAlquilar").value = idPelicula;
	    parent.document.getElementById('NuevoPedido1').action = "../AgregarPeliculaServlet";
	    parent.document.getElementById('NuevoPedido1').submit();
	}
	
	</script>    

    <head>
        <link rel="stylesheet" type="text/css" href="../Styles/cs_basic.css" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Agregar película</title>
    </head>
    <body>
        <table width="100%" id="grey" cellspacing="1" cellpadding="1">
            <tr>
                <td>
                    <h2>Agregar pel&iacute;cula</h2>
                </td>
                <td colspan="2" align="right">
                    <image src="../Images/peliculas.JPG" height="140" width="140"/>
                </td>
            </tr>
        </table>
        <form id="AgregarPelicula" name="AgregarPelicula" method="post" action="AgregarPelicula.jsp">
            <%
            Home<Pelicula> daoPeliculas = Videoclub.getInstance().getHome(Pelicula.class);
            pageContext.setAttribute("generos", Videoclub.getInstance().getGeneros());
            
            Pelicula peliBuscar = new Pelicula(request.getParameter("titulo"), "", request.getParameter("genero"));
            List<Pelicula> peliculas = daoPeliculas.searchByExample(peliBuscar);
            pageContext.setAttribute("peliculasBusqueda", peliculas);
            %>
            <table width="80%">
                <tr>
                    <td align="right">Género:</td>
                    <td align="left">
                        <select id="genero" name="genero">
                            <option value=""></option>
                            <c:forEach var="generoCombo" items="${generos}">
                                <c:choose>
                                    <c:when test="${generoCombo==param.genero}">
                                        <option value="${generoCombo}" selected>
                                            ${generoCombo}
                                            </option>
                                    </c:when> 
                                    <c:otherwise>
                                        <option value="${generoCombo}">
                                            ${generoCombo}
                                        </option>
                                    </c:otherwise>
                                </c:choose>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td align="right">Título contiene:</td>
                    <td align="left">
                        <input type="text" id="titulo" name="titulo" size="30" value="<%= request.getParameter("titulo") == null ? "" : request.getParameter("titulo") %>"/>
                    </td>
                </tr>
                <tr>
                    <td height="20"></td>
                </tr>
                <tr>
                    <td colspan="2" align="center">
                        <input type="submit" style="cursor:hand" value="Buscar"/>
                        <input type="button" style="cursor:hand" value="Limpiar" onclick="javascript:limpiar();"/>
                    </td>
                </tr>
            </table>         
            <br/>
            <table id="gris" border="1" width="100%" cellpadding="2" cellspacing="2">
                <th>
                    T&iacute;tulo
                </th>
                <th>
                    Director
                </th>
                <th>
                    G&eacute;nero
                </th>    
                <th/>
                <c:forEach var="pelicula" items="${peliculasBusqueda}">
                    <tr>
                        <td>
                            <c:out value="${pelicula.nombre}"/>
                        </td>
                        <td>
                            <c:out value="${pelicula.director}"/>
                        </td>                
                        <td>
                            <c:out value="${pelicula.genero}"/>
                        </td>                
                        <td align="center">
                            <image src="../Images/alquilar.gif" style="cursor:hand" alt="alquilar <c:out value="${pelicula.nombre}"/>" onclick="javascript:alquilar('<c:out value="${pelicula.id}"/>');"/>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </form>
    </body>
</html>
