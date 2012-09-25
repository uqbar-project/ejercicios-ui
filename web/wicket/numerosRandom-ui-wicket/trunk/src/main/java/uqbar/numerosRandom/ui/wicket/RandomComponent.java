package uqbar.numerosRandom.ui.wicket;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.form.AjaxButton;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.CompoundPropertyModel;

import uqbar.numerosRandom.model.GeneradorRandom;


public class RandomComponent extends Panel {

	private static final long serialVersionUID = 1L;

	public RandomComponent(String id, GeneradorRandom random) {
		super(id, new CompoundPropertyModel<GeneradorRandom>(random));
		
        // Add the simplest type of label
        final Label label = new Label("resultado");
		label.setOutputMarkupId(true);
        add(label);
        
        Form form = new Form("form");
        form.add(new AjaxButton("boton") {

			@Override
			protected void onSubmit(AjaxRequestTarget target, Form<?> form) {
				((GeneradorRandom)RandomComponent.this.getDefaultModelObject()).generar();
				target.addComponent(label);
			}
        	
        });
        add(form);
	}
	
	public RandomComponent(String id, int desde, int hasta) {
		this(id, new GeneradorRandom(desde, hasta));
	}


}
