package uqbar.examples.web.mentawai.conversor.basico;

import org.mentawai.core.ApplicationManager;

/**
 * 
 * @author jfernandes
 */
public class ConversorApplicationManager extends ApplicationManager {
	
	public void loadActions() {
        action("/ConversorBasicoAction", ConversorBasicoAction.class)
        	.fwdOk("/basico.jsp")
        	.fwdError("/basico.jsp");
        action("/ConversorConModeloAction", ConversorBasicoAction.class).fwdOk("/conModelo.jsp");
    }

}
