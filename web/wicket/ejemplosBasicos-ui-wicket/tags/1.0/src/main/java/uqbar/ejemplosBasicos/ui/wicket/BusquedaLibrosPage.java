package uqbar.ejemplosBasicos.ui.wicket;

import org.apache.wicket.Component;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.SubmitLink;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.PropertyListView;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;

import uqbar.ejemplosBasicos.applicationModel.BuscadorLibros;
import uqbar.ejemplosBasicos.domain.Libro;


public class BusquedaLibrosPage extends WebPage {
	private Component panelResultado;
	private final BuscadorLibros buscador;
	private TextField textoBusqueda;

	public BusquedaLibrosPage(final PageParameters parameters) {
		this.buscador = new BuscadorLibros();
		Form buscarForm = new Form("buscarLibrosForm", new CompoundPropertyModel(this.buscador));
		this.addSearchFields(buscarForm);
		this.addResults(buscarForm);
		this.addActions(buscarForm);
		
		this.add(buscarForm);
	}
	
	/**
	 * Crea y agrega los campos con los que se hace la busqueda. Estos controles se bindean automaticamente
	 * con las properties del modelo del form, que es un objeto de tipo {@link ListadoSocios}.
	 */
	protected void addSearchFields(Form buscarForm) {
		textoBusqueda = new TextField("tituloBusqueda");
		buscarForm.add(textoBusqueda); 
	}


	protected void addResults(Form buscarForm) {
		this.panelResultado = new PropertyListView<Libro>("resultado") {
			@Override
			protected void populateItem(ListItem<Libro> item) {
				item.add(new Label("titulo"));
				item.add(new Label("autor"));
			}
		};
		buscarForm.add(this.panelResultado);
	}

	/**
	 * Agrega los botones que representan acciones
	 */
	protected void addActions(Form form) {
		form.add(new SubmitLink("buscar") {
			@Override
			public void onSubmit() {
				BuscadorLibros buscadorLibros = BusquedaLibrosPage.this.buscador;
				buscadorLibros.buscar();
			}
		});

    	form.add(new Link<Object>("linkVolver") {
			@Override
			public void onClick() {
				this.setResponsePage(HomePage.class);
			}
		});
		
	}

	/**
	 * Retorna el componente wicket que contiene el resultado de la busqueda. Se utiliza para que los botones
	 * lo refresquen via ajax.
	 */
	public Component getResultado() {
		return this.panelResultado;
	}

}
