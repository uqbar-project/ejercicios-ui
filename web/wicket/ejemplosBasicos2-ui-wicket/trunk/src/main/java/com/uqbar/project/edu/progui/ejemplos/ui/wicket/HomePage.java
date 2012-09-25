package com.uqbar.project.edu.progui.ejemplos.ui.wicket;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.PropertyListView;
import org.apache.wicket.request.mapper.parameter.PageParameters;

/**
 * Homepage
 */
public class HomePage extends WebPage {

	private static final long serialVersionUID = 1L;

	// TODO Add any page properties or variables here

	/**
	 * Constructor that is invoked when page is invoked without a session.
	 * 
	 * @param parameters Page parameters
	 */
	public HomePage(final PageParameters parameters) {
		// Add the simplest type of label
		add(new Label("message", this.getHoraActual()));
		add(new PropertyListView<MenuAction>("links", this.getOpciones()) {
			private static final long serialVersionUID = 1L;

			@Override
			protected void populateItem(final ListItem<MenuAction> item) {
				Link<Object> link = new Link<Object>("link") {
					private static final long serialVersionUID = 1L;

					@Override
					public void onClick() {
						this.setResponsePage(item.getModelObject().getResponsePage());
					}
				};
				
				link.add(new Label("linkName"));
				item.add(link);

			}

		});
	}

	public String getHoraActual() {
		return new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date());
	}

	public List<MenuAction> getOpciones() {
		List<MenuAction> opciones = new ArrayList<MenuAction>();
		opciones.add(new MenuAction("Calculadora Común", CalculadoraPage.class));
		opciones.add(new MenuAction("Calculadora (usando ajax)", CalculadoraAjaxPage.class));
		opciones.add(new MenuAction("Búsqueda de libros", BusquedaLibrosPage.class));
		opciones.add(new MenuAction("Conversor", ConversorPage.class));
		opciones.add(new MenuAction("Conversor con validación manual", ConversorPageValidandoPI.class));
		
		return opciones;

	}
}
