package com.uqbar.project.edu.progui.ejemplos.ui.wicket;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.form.AjaxButton;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.PropertyListView;
import org.apache.wicket.model.CompoundPropertyModel;

import com.uqbar.project.edu.progui.ejemplos.ui.domain.BuscadorLibros;
import com.uqbar.project.edu.progui.ejemplos.ui.domain.Libro;

public class BusquedaLibrosPage extends WebPage {
	private final BuscadorLibros buscador;
	private Form<BuscadorLibros> buscarForm;

	public BusquedaLibrosPage() {
		this.buscador = new BuscadorLibros();
		this.buscarForm = new Form<BuscadorLibros>( //
				"buscarLibrosForm", //
				new CompoundPropertyModel<BuscadorLibros>(this.buscador));
		this.addSearchFields(buscarForm);
		this.addResults(buscarForm);
		this.addActions(buscarForm);

		this.add(buscarForm);
	}

	/**
	 * Crea y agrega los campos con los que se hace la busqueda. Estos controles
	 * se bindean automaticamente con las properties del modelo del form, que es
	 * un objeto de tipo {@link ListadoSocios}.
	 */
	protected void addSearchFields(Form<BuscadorLibros> buscarForm) {
		buscarForm.add(new TextField<String>("tituloBusqueda"));
	}

	protected void addResults(Form<BuscadorLibros> buscarForm) {
		buscarForm.add(new PropertyListView<Libro>("resultado") {
			@Override
			protected void populateItem(ListItem<Libro> item) {
				item.add(new Label("titulo"));
				item.add(new Label("autor"));
			}
		});
	}

	/**
	 * Agrega los botones que representan acciones
	 */
	protected void addActions(Form<BuscadorLibros> form) {
		form.add(new AjaxButton("buscar") {
			@Override
			protected void onSubmit(AjaxRequestTarget target, Form<?> form) {
				buscador.buscar();
				target.addComponent(buscarForm);
			}

			@Override
			protected void onError(AjaxRequestTarget target, Form<?> form) {
			}
		});

		form.add(new Link<Object>("linkVolver") {
			@Override
			public void onClick() {
				this.setResponsePage(HomePage.class);
			}
		});

	}
}
