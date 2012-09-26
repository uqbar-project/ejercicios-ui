package com.uqbar.project.edu.progui.ejemplos.ui.wicket;

import org.apache.wicket.Component;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.form.AjaxSubmitLink;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;

import com.uqbar.project.edu.progui.ejemplos.ui.domain.Calculadora;

public class CalculadoraAjaxPage extends WebPage {

	private static final long serialVersionUID = 1L;

	private Calculadora calculadora;
	private Component labelResultado;
	private Component feedbackPanel;

	/**
	 * Constructor that is invoked when page is invoked without a session.
	 * 
	 * @param parameters Page parameters
	 */
	public CalculadoraAjaxPage(final PageParameters parameters) {
		Form form = new Form("calculadoraAjaxForm", this.createModel());
		this.add(form);

		this.addFields(form);
		this.addActions(form);
	}

	private void addActions(Form form) {
		form.add(new AjaxSubmitLink("sumar") {
			@Override
			public void onSubmit(AjaxRequestTarget destino, Form form) {
				destino.addComponent(labelResultado);
			}

			@Override
			protected void onError(AjaxRequestTarget target, Form<?> form) {
				target.addComponent(feedbackPanel);
				// CalculadoraAjaxPage.this.feedbackPanel.set
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

		labelResultado = new Label("resultado").setOutputMarkupId(true);
		form.add(labelResultado);

		feedbackPanel = new FeedbackPanel("feedbackPanel").setOutputMarkupId(true);
		form.add(feedbackPanel);
	}

	protected CompoundPropertyModel<Calculadora> createModel() {
		this.calculadora = new Calculadora();
		return new CompoundPropertyModel<Calculadora>(this.calculadora);
	}

}
