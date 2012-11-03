package uqbar.examples.conversor.ui.stripes.stripes.action;

import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.ErrorResolution;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.action.UrlBinding;

/**
 * @author jfernandes
 */
@UrlBinding("/Conversor.htm")
public class ConversorActionBean extends BaseActionBean {
	private double millas;
	private double kilometros;

    @DefaultHandler
    public Resolution convertir() {
    	if (millas <= 0) {
    		return new ErrorResolution(0, "Blah");
    	}
    	this.kilometros = this.millas * 1.60934;
        return new ForwardResolution("/conversor.jsp");
    }
    
    public double getMillas() {
		return millas;
	}
    
    public void setMillas(double millas) {
		this.millas = millas;
	}
    
    public double getKilometros() {
		return kilometros;
	}
    
    public void setKilometros(double kilometros) {
		this.kilometros = kilometros;
	}
    
}