/**
 * 
 */
package uqbar.videoclub.ui.wicket.pages;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.CompoundPropertyModel;


import tadp.blocbaster.entidades.Socio;
import tadp.blocbaster.exceptions.BusinessException;
import uqbar.videoclub.model.ListadoSocios;
import uqbar.videoclub.model.NuevoSocio;

/**
 * Pagina de creacion de un {@link Socio}. <br/>
 * Sigue la misma idea que {@link ListadoSociosPage}. Es decir tiene un objeto caso de uso como modelo, de
 * tipo {@link NuevoSocio}.
 * 
 * @see NuevoSocio
 * @see FeedbackPanel
 * @see CompoundPropertyModel
 * 
 * @author jfernandes
 */
public class NuevoSocioPage extends WebPage {
	private FeedbackPanel feedbackPanel;
	private WebPage paginaOrigen;

	public NuevoSocioPage(AbstractWebPage<ListadoSocios> laPaginaDeLaQueMeLlamaron) {
		this.paginaOrigen = laPaginaDeLaQueMeLlamaron;

		Form<NuevoSocio> form = new Form<NuevoSocio>("nuevoClienteForm", this.createModel());
		this.add(form);

		this.addFields(form);
		this.addButtons(form);

	}

	/**
	 * Crea el modelo del formulario que sera' el caso de uso.
	 */
	protected CompoundPropertyModel<NuevoSocio> createModel() {
		return new CompoundPropertyModel<NuevoSocio>(new NuevoSocio((ListadoSocios) this.paginaOrigen.getDefaultModelObject()));
	}

	/**
	 * Crea y agrega los controles para editar el nuevo cliente.
	 */
	protected void addFields(Form<NuevoSocio> form) {
		form.add(new TextField<String>("nombre"));
		form.add(new TextField<String>("direccion"));
		form.add(this.feedbackPanel = new FeedbackPanel("feedbackPanel"));
	}

	/**
	 * Crea y agrega los botones: aceptar y cancelar.
	 */
	protected void addButtons(Form<NuevoSocio> form) {
		form.add(new Button("aceptar") {
			@Override
			public void onSubmit() {
				try {
					// invoca la logica de negocio
					((NuevoSocio) this.getParent().getDefaultModelObject()).aceptar();
					// navegacion: vuelve a la pagina de busqueda.
					this.setResponsePage(NuevoSocioPage.this.paginaOrigen);
				}
				catch (RuntimeException e) {
					// en caso de excepcion de negocio muestra el mensaje como un error.
					// Ej: nombre y/o direccion vacios.
					NuevoSocioPage.this.feedbackPanel.error(e.getMessage());
					getRequestCycle().onRuntimeException(NuevoSocioPage.this, e);
				}
			}
		});

		form.add(new Button("cancelar") {
			@Override
			public void onSubmit() {
				// vuelve a una 'nueva' instancia de la pagina ListadoSociosPage
				// tal vez seria deseable regresar a la misma instancia para mantener el estado
				// en los campos de busqueda y la lista resultado de la ultima busqueda.
				this.setResponsePage(ListadoSociosPage.class);
			}
		});
	}

}