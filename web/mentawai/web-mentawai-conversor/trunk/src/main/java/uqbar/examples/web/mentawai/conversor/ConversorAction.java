package uqbar.examples.web.mentawai.conversor;

import org.mentawai.core.BaseAction;

/**
 * 
 * @author jfernandes
 */
public class ConversorAction extends BaseAction {

	public String execute() {
		return SUCCESS;
    }
	
	public String convertir() {
		System.out.println("Hola mundi !!!");
		double millas = this.input.getDouble("millas");
		double kilometros = this.convertir(millas);
		this.output.setValue("kilometros", kilometros);
		return SUCCESS;
	}

	protected double convertir(double millas) {
		return millas * 1.60934;
	}
	
}
