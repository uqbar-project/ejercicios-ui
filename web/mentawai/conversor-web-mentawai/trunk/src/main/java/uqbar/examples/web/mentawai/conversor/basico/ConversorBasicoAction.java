package uqbar.examples.web.mentawai.conversor.basico;

import org.mentawai.core.BaseAction;
import org.mentawai.message.DefaultMessage;

/**
 * 
 * @author jfernandes
 */
public class ConversorBasicoAction extends BaseAction {

	public String execute() {
		return SUCCESS;
    }
	
	public String convertir() {
		try {
			double millas = this.input.getDouble("millas");
			double kilometros = this.convertir(millas);
			this.output.setValue("kilometros", kilometros);
			return SUCCESS;
		}
		catch (Exception e) {
			addError("millas", new DefaultMessage("errorMillas", msgContext));
			return ERROR;
		}
	}

	protected double convertir(double millas) {
		return millas * 1.60934;
	}
	
}
