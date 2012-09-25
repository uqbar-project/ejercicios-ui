package uqbar.videoclub.model;

import tadp.blocbaster.entidades.Pedido;
import tadp.blocbaster.entidades.Pelicula;
import tadp.blocbaster.entidades.Socio;

/**
 * @author jfernandes
 */
//REFACTORME: despues de un refactor en el dominio parece que se perdieron los application models
// del alquiler!
public class AlquilarPeliculas extends AbstractVideoClubObject {
	private Socio socio;
//	private SeleccionarPelicula seleccionar = new SeleccionarPelicula();
	private Pedido pedido = new Pedido();

	public AlquilarPeliculas(Socio socio) {
		super();
		this.socio = socio;
	}

	public Socio getSocio() {
		return this.socio;
	}

/*	public SeleccionarPelicula getSeleccionar() {
		return this.seleccionar;
	}
*/
	public Pedido getPedido() {
		return this.pedido;
	}

	public void agregarPelicula(Pelicula pelicula) {
		this.getPedido().addPelicula(pelicula);
	}

}