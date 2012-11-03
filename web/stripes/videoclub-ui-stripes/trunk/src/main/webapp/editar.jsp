<%@ include file="/taglibs.jsp" %>

<stripes:layout-render name="/layout.jsp" title="Welcome">
  <stripes:layout-component name="body">
    
     <table width="80%">
            <tr>
                <td>
                    <img src="images/videoclub.jpg" />
                </td>
                <td>
                    <h1><c:out value="${titulo}"/></h1>
                </td>
            </tr>
        </table>
        
        <stripes:form beanclass="uqbar.videoclub.web.stripes.action.EditarSocioActionBean" name="editarSocio" method="post">
        	<stripes:hidden name="id" value="${socio.id}" />
            <table width="80%">
                <tr>
                    <td align="right">Nombre:</td>
                    <td align="left">
                    	<stripes:text name="socio.nombre" />
                    </td>
                </tr>
                <tr>
                    <td align="right">Direccion:</td>
                    <td align="left">
                    	<stripes:text name="socio.direccion" />
                    </td>
                </tr>
                <tr>
                    <td height="20"></td>
                </tr>
                <tr>
                    <td colspan="2" align="center">
                    	<stripes:submit name="guardar" value="Aceptar" />
                    	<stripes:button name="cancelar" value="Cancelar" onclick="document.location='Home.htm'"/>
                    </td>
                </tr>
            </table>
        </stripes:form>
    
  </stripes:layout-component>
</stripes:layout-render>
