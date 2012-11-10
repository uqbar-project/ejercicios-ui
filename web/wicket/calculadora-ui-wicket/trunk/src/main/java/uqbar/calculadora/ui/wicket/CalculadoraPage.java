package uqbar.calculadora.ui.wicket;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;

import uqbar.calculadora.domain.Calculadora;


public class CalculadoraPage extends WebPage {

	private static final long serialVersionUID = 1L;

	private Calculadora calculadora;
    /**
	 * Constructor that is invoked when page is invoked without a session.
	 * 
	 * @param parameters
	 *            Page parameters
	 */
    public CalculadoraPage(final PageParameters parameters) {
    	this.calculadora = new Calculadora();
    	
		Form<Calculadora> form = new Form<Calculadora>("calculadoraForm");
		this.add(form);

		this.addFields(form);
		this.addActions(form);
    }
    
	private void addActions(Form<Calculadora> form) {
		form.add(new Button("sumar") {
			@Override
			public void onSubmit() {
				//CalculadoraPage.this.calculadora.sumar();
			}
		});
	}

	private void addFields(Form<Calculadora> form) {
		form.add(new TextField<Double>("operando1", new PropertyModel<Double>(this.calculadora, "sumando1")));
		form.add(new TextField<Double>("operando2", new PropertyModel<Double>(this.calculadora, "sumando2")));
		form.add(new Label("resultado", new PropertyModel<String>(this.calculadora, "resultado")));
		form.add(new FeedbackPanel("feedbackPanel"));		
	}

}
