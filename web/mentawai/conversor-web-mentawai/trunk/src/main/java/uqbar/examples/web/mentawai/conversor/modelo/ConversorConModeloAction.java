package uqbar.examples.web.mentawai.conversor.modelo;

import org.mentawai.core.BaseAction;

/**
 * 
 * @author jfernandes
 */
public class ConversorConModeloAction extends BaseAction {

	public String execute() {
		return SUCCESS;
    }
	
	public String convertir() {
		Conversor conversor = input.getObject(Conversor.class);
		conversor.convertir();
		output.setObject(conversor);
		return SUCCESS;
	}

}
