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

import uqbar.ejemplosBasicos.domain.Conversor;


public class ConversorPage extends WebPage {

	private Conversor conversor;
    /**
	 * Constructor that is invoked when page is invoked without a session.
	 */
    public ConversorPage(final PageParameters parameters) {
		Form<Conversor> form = new Form<Conversor>("conversorForm", this.createModel());
		this.add(form);
		this.addFields(form);
		this.addActions(form);
    }
    
	protected void addActions(Form<Conversor> form) {
		form.add(new Button("convertir") {

			@Override
			public void onSubmit() {
				conversor.convertir();
			}
		});

    	form.add(new Link<Object>("linkVolver") {
			private static final long serialVersionUID = 1L;

			@Override
			public void onClick() {
				this.setResponsePage(HomePage.class);
			}
		});
	}

	private void addFields(final Form<Conversor> form) {
		form.add(this.createMillasField(form));
		form.add(new Label("resultado"));
		form.add(new FeedbackPanel("feedbackPanel"));		
	}

	protected TextField<Double> createMillasField(final Form<Conversor> form) {
		return new TextField<Double>("millas");
	}

	protected CompoundPropertyModel<Conversor> createModel() {
		this.conversor = new Conversor();
		return new CompoundPropertyModel<Conversor>(this.conversor);
	}

}
