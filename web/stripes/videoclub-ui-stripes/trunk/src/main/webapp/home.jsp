<%@ include file="/taglibs.jsp" %>

<stripes:layout-render name="/layout.jsp" title="Welcome">
  <stripes:layout-component name="body">
    
    <table width="80%">
            <tr>
                <td>
                    <image src="images/videoclub.jpg"/>
                </td>
                <td>
                    <h1>Actualizaci&oacute;n de Clientes</h1>
                </td>
            </tr>
        </table>
        
        <stripes:form beanclass="uqbar.videoclub.web.stripes.action.HomeActionBean" focus="">
            <table width="80%">
                <tr>
                    <td align="right">Nombre contiene:</td>
                    <td align="left">
                    	<stripes:text name="listadoSocios.nombre" />
                    </td>
                </tr>
                <tr>
                    <td align="right">Direcci&oacute;n contiene:</td>
                    <td align="left">
                    	<stripes:text name="listadoSocios.direccion" />
                    </td>
                </tr>
                <tr>
                    <td height="20"></td>
                </tr>
                <tr>
                    <td colspan="2" align="center">
                    	<input type="submit" name="buscar" value="Buscar"/>
                        <input type="submit" name="limpiar" value="Limpiar"/>
                        <input type="button" name="crear" value="Nuevo Cliente"/>
                    </td>
                </tr>
            </table>
            <br/>
            
            <div>
            	<table id="main" width="80%">
            		<tr>
                		<th width="40%">Nombre completo</th>
                		<th width="40%">Direcci&oacute;n</th>
                		<th width="6%"/>
                		<th width="8%"/>
       				</tr>
       				<c:forEach items="${actionBean.listadoSocios.resultado}" var="socio">
                   	<tr>
                    	<td width="40%">
                    	    <span>${socio.nombre}</span> 
                	    </td> 
            	        <td width="40%">
        	            	<span>${socio.direccion}</span>
    	                </td> 
                	    <td>
                	    	<stripes:link beanclass="uqbar.videoclub.web.stripes.action.HomeActionBean" event="delete" style="background-color:none;padding:0px;text-decoration: none;">
                	    		<stripes:param name="idSocioSeleccionado" value="${socio.id}" />
            	            	<image src="images/delete.gif" alt="eliminar el cliente" />
            	            </stripes:link>
        	            </td>
    	                <td>
    	                	<stripes:link beanclass="uqbar.videoclub.web.stripes.action.EditarSocioActionBean">
    	                		<stripes:param name="id" value="${socio.id}" />
	                        	<image src="images/alquilar.gif" alt="Editar" />
	                        </stripes:link>
                    	</td>                    
                	</tr>
                	</c:forEach>
            	</table>
            </div>
        </stripes:form>
    
  </stripes:layout-component>
</stripes:layout-render>
