package uqbar.ejemplosBasicos.ui.wicket;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;

import uqbar.ejemplosBasicos.domain.Calculadora;


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
		Form form = new Form("calculadoraForm", this.createModel());
		this.add(form);

		this.addFields(form);
		this.addActions(form);
    }
    
	private void addActions(Form form) {
		form.add(new Button("sumar") {
			@Override
			public void onSubmit() {
				CalculadoraPage.this.calculadora.sumar();
			}
		});

    	form.add(new Link<Object>("linkVolver") {
			@Override
			public void onClick() {
				this.setResponsePage(HomePage.class);
			}
		});
	}

	private void addFields(Form form) {
		form.add(new TextField("operando1"));
		form.add(new TextField("operando2"));
		form.add(new Label("resultado"));
		form.add(new FeedbackPanel("feedbackPanel"));		
	}

	protected CompoundPropertyModel createModel() {
		this.calculadora = new Calculadora();
		return new CompoundPropertyModel(this.calculadora);
	}

}
