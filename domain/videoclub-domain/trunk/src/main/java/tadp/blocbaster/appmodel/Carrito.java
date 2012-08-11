package tadp.blocbaster.appmodel;

import java.util.List;

import org.uqbar.commons.model.ObservableObject;

import tadp.blocbaster.entidades.Pelicula;

/**
 * 
 * @author npasserini
 */
public class Carrito extends ObservableObject {
	public static final String PELICULAS = "peliculas";

	private List<Pelicula> peliculas;

	public List<Pelicula> getPeliculas() {
		return this.peliculas;
	}

	public double getTotal() {
		double total = 0.0;
		for (Pelicula pelicula : this.peliculas) {
			total += pelicula.getCosto();
		}
		return total;
	}
}
