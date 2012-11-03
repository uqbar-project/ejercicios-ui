<%@ include file="/taglibs.jsp" %>

<stripes:layout-render name="/layout.jsp" title="Conversor Stripes">
  <stripes:layout-component name="body">

<h1>Conversor Stripes</h1>

    <stripes:form beanclass="uqbar.examples.conversor.ui.stripes.stripes.action.ConversorActionBean" focus="">
    	<stripes:errors globalErrorsOnly="true" />
        <table>
            <tr>
                <td>Millas:</td>
                <td><stripes:text name="millas"/>
                <stripes:errors field="millas"/>
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <stripes:submit name="convertir" value="Convertir"/>                    
                </td>
            </tr>
            <tr>
                <td>Kilometros:</td>
                <td><span class="kilometros">${actionBean.kilometros}</span></td>
            </tr>
        </table>
    </stripes:form>

  </stripes:layout-component>
</stripes:layout-render>