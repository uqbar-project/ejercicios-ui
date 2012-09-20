package uqbar.examples.web.mentawai.conversor;

import org.mentawai.core.ApplicationManager;

/**
 * 
 * @author jfernandes
 */
public class ConversorApplicationManager extends ApplicationManager {
	
	public void loadActions() {
        action("/ConversorAction", ConversorAction.class).fwdOk("/index.jsp");
    }

}
