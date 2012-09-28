package uqbar.contador.ui.wicket;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;

public class HomePage extends WebPage {
	private static final long serialVersionUID = 1L;
	private int contador;
	
    public HomePage(final PageParameters parameters) {
        final Label labelContador = new Label("contador", new PropertyModel(this, "contador"));
        add(labelContador);
        labelContador.setOutputMarkupId(true);
        add(new AjaxLink<Object>("sumar") {

			@Override
			public void onClick(AjaxRequestTarget target) {
				if (target != null) {
					contador++;
					target.addComponent(labelContador);					
				}
			}
		});
		add(new AjaxLink<Object>("restar") {
			@Override
			public void onClick(AjaxRequestTarget target) {
				if (target != null) {
					contador--;
					target.addComponent(labelContador);					
				}
			}
		});
    }
}