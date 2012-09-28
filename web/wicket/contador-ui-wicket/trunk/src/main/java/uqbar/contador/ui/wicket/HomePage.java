package uqbar.contador.ui.wicket;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;

public class HomePage extends WebPage {
	private static final long serialVersionUID = 1L;
	private int contador;
	
    public HomePage(final PageParameters parameters) {
        // TODO Add your page's components here
        add(new Label("contador", new PropertyModel(this, "contador")));
        add(new Link<Object>("sumar") {

			@Override
			public void onClick() {
				contador++;
			}
		});
		add(new Link<Object>("restar") {
			@Override
			public void onClick() {
				contador--;
			}
		});    	
    }
}

