/**
 * 
 */
package uqbar.videoclub.ui.wicket.pages.alquiler;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.CompoundPropertyModel;

import uqbar.videoclub.model.AlquilarPeliculas;


/**
 * @author jfernandes
 */
public class SeleccionarPeliculasPage extends WebPage {
	
	public SeleccionarPeliculasPage(AlquilarPeliculas alquilarPeliculas) {
		this.setDefaultModel(new CompoundPropertyModel(alquilarPeliculas));
		this.addCarritoSection();
		this.addSeleccionPeliculaSection();
		this.addFooter();
	}

	protected void addCarritoSection() {
		this.add(new CarritoPanel("carrito", this.getAlquilarPeliculasModel().getPedido()));
	}
	
	protected void addSeleccionPeliculaSection() {
		//this.add(new SeleccionarPeliculasPanel("seleccionar", this.getAlquilarPeliculasModel()));
		this.add(new Panel("seleccionar"));
	}

	protected void addFooter() {
		this.add(new Label("socio"));
	}
	
	protected AlquilarPeliculas getAlquilarPeliculasModel() {
		return (AlquilarPeliculas) this.getDefaultModelObject();
	}

}
