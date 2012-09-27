package uqbar.videoclub.ui.wicket.pages.alquiler;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.form.AjaxButton;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.ComponentPropertyModel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.Model;

import tadp.blocbaster.entidades.Pelicula;
import uqbar.videoclub.model.AlquilarPeliculas;

/**
 * 
 * @author jfernandes
 */
public class SeleccionarPeliculasPanel extends Panel {
	private static final long serialVersionUID = 1017239982582239643L;

	public SeleccionarPeliculasPanel(String id, AlquilarPeliculas alquilarPeliculas) {
		super(id);
		this.setDefaultModel(new Model(alquilarPeliculas));

//		Form form = new Form("busquedaForm", new CompoundPropertyModel(alquilarPeliculas.getSeleccionar()));
		Form form = new Form("busquedaForm");
		form.setOutputMarkupId(true);

		this.addSearchFields(form);
		this.addButtons(form);
		this.addResultSection(form);

		this.add(form);
	}

	/**
	 * 
	 */
	protected void addSearchFields(Form form) {
		form.add(new DropDownChoice("genero", new ComponentPropertyModel("generosPosibles")));
		form.add(new TextField("nombre"));
	}

	/**
	 * 
	 */
	protected void addButtons(Form form) {
		form.add(new AjaxButton("buscar") {
			@Override
			protected void onSubmit(AjaxRequestTarget target, Form form) {
				getAlquilarPeliculasModel().buscar();
				target.addComponent(this.getParent().get("resultSection"));
			}
		});

		form.add(new AjaxButton("limpiar") {
			@Override
			protected void onSubmit(AjaxRequestTarget target, Form form) {
				getAlquilarPeliculasModel().limpiar();
				target.addComponent(this.getParent());
			}
		});
	}

	protected void addResultSection(Form form) {
		WebMarkupContainer resultSection = new WebMarkupContainer("resultSection");
		resultSection.setOutputMarkupId(true);

		resultSection.add(new ListView("peliculasPosibles") {
			@Override
			protected void populateItem(ListItem item) {
				item.setModel(new CompoundPropertyModel(item.getModelObject()));

				item.add(new Label("nombre"));
				item.add(new Label("director"));
				item.add(new Label("genero"));

				item.add(new Link("alquilar") {
					@Override
					public void onClick() {
						Pelicula pelicula = (Pelicula) this.getParent().getDefaultModelObject();
						getAlquilarPeliculasModel().alquilarPelicula(pelicula);
					}
				});
			}
		});
		form.add(resultSection);
	}

	protected AlquilarPeliculas getAlquilarPeliculasModel() {
		return (AlquilarPeliculas) this.getDefaultModelObject();
	}
}
