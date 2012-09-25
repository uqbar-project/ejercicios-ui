/**
 * 
 */
package uqbar.videoclub.ui.wicket.components;

import java.awt.TextField;

import org.apache.wicket.Component;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;

import tadp.blocbaster.entidades.Socio;
import uqbar.videoclub.model.AlquilarPeliculas;
import uqbar.videoclub.model.ListadoSocios;
import uqbar.videoclub.ui.wicket.pages.alquiler.SeleccionarPeliculasPage;

/**
 * Subclase de {@link ListView} para {@link Socio}'s.
 * 
 * El control {@link ListView} es un control generico de wicket para mostrar una lista de objetos, ya sea
 * <ol>
 * <li>un 'table' html</li>
 * <li>o como una lista html utilizando tags ol, li, etc<i>
 * <li>en fin, como se haya definido a nivel de disenho grafico</li>
 * </ol>
 * Este componente es abstracto por lo que delega en las subclases (como esta) la responsabilidad de, <b>por
 * cada item <i>({@link Socio} en nuestro caso)</i> crear los componentes wicket que uno quiera. Esto a traves
 * del metodo {@link #populateItem(ListItem)}.
 * 
 * De esta form podriamos crear una tabla editable utilizando controles como {@link TextField}, o una lista
 * simple de datos utilizando {@link Label}. Ademas, obviamente se puede utilizar cualquier tipo de componente
 * como {@link Link}'s, {@link Button}'s, etc.
 * 
 * @author jfernandes
 */
public class SociosListView extends AbstractListView {
	private Component resultSection;
	private ListadoSocios listadoSocios;

	public SociosListView(String id, Component resultSection, ListadoSocios listadoSocios) {
		super(id);
		this.resultSection = resultSection;
		this.listadoSocios = listadoSocios;
	}

	/**
	 * Por cada {@link Socio} creamos los componentes para mostrarlo.
	 */
	@Override
	protected void populateItem(final ListItem item) {
		// cambiamos el modelo que wrappea a nuestro socio por un CompoundPropertyModel
		// que nos permite 'heredar' el modelo a los controles que vamos a agregar, para tener
		// binding automatico dado los id's de los controles.
		// item.setModel(new CompoundPropertyModel(item.getModelObject()));

		item.add(new Label("nombre"));
		item.add(new Label("direccion"));

		item.add(new AjaxLink("eliminar") {
			@Override
			public void onClick(AjaxRequestTarget target) {
				Socio socio = (Socio) this.getParent().getDefaultModelObject();
				SociosListView.this.listadoSocios.eliminar(socio);

				target.addComponent(SociosListView.this.resultSection);
			}
		});

		item.add(new Link("alquilar") {
			@Override
			public void onClick() {
				this.setResponsePage(new SeleccionarPeliculasPage(new AlquilarPeliculas((Socio) item.getModelObject())));
			}
		});
	}
}