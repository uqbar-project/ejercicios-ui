package uqbar.videoclub.ui.wicket.pages;

import org.apache.wicket.Component;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;

import uqbar.videoclub.model.ListadoSocios;
import uqbar.videoclub.ui.wicket.components.SociosListView;


/**
 * Objeto java que representa la vista de la pagina de "listado de socios". En esta pagina el usuario puede:
 * <ol>
 * <li>Buscar socios por: nombre o direccion.</li>
 * <li>A partir de la lista resultado puede: eliminar; editar; o alquilar un pelicula para un usuario dado.</li>
 * <li>Crear un nuevo usuario. {@link NuevoSocioPage}
 * </ol>
 * 
 * Este disenho esta' basado en la idea de <b>modelo de caso de uso</b> o de aplicacio'n que tambie'n
 * utilizamos en la implementacio'n de <b>jface</b> <i>(swt)</swt>.
 * 
 * @see ListadoSocios
 * @see NuevoSocioPage
 * 
 * @author jfernandes
 */
public class ListadoSociosPage extends AbstractWebPage<ListadoSocios> {
	private Component resultSection;

	public ListadoSociosPage() {
		super(new ListadoSocios());
		
		Form<ListadoSocios> buscarForm = this.createForm("buscarForm");
		this.addSearchFields(buscarForm);
		this.addResults(buscarForm);
		this.addButtons(buscarForm);
		
		this.add(buscarForm);
	}

	/**
	 * Crea y agrega los campos con los que se hace la busqueda. Estos controles se bindean automaticamente
	 * con las properties del modelo del form, que es un objeto de tipo {@link ListadoSocios}.
	 */
	protected void addSearchFields(Form<ListadoSocios> buscarForm) {
		buscarForm.add(new TextField<String>("nombre")); // edita la property 'nombre' de ListadoSocios.
		buscarForm.add(new TextField<String>("direccion")); // edita la property 'direccion' de ListadoSocios.
	}


	protected void addResults(Form<ListadoSocios> buscarForm) {
		this.resultSection = this.createResultsSection();
		buscarForm.add(this.resultSection);
	}

	protected WebMarkupContainer createResultsSection() {
		WebMarkupContainer panel = new WebMarkupContainer("resultSection");
		panel.setOutputMarkupId(true);
		panel.add(new SociosListView("resultado", panel, this.getModelObject()));
		return panel;
	}

	/**
	 * Agrega los botons: buscar, limpiar & nuevoCliente; al formulario.
	 */
	protected void addButtons(Form<ListadoSocios> form) {
		form.add(new SuperAjaxButton<ListadoSocios>("buscar", form, this.getResultSection()));
		form.add(new SuperAjaxButton<ListadoSocios>("limpiar", form, this.getResultSection()));
		form.add(new PageLink("nuevoCliente", new NuevoSocioPage(this)));
	}

	/**
	 * Retorna el componente wicket que contiene el resultado de la busqueda. Se utiliza para que los botones
	 * lo refresquen via ajax.
	 */
	public Component getResultSection() {
		return this.resultSection;
	}
}
