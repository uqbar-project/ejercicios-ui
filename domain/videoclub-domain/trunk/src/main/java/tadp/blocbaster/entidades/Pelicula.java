package tadp.blocbaster.entidades;

import org.uqbar.commons.model.Entity;
import org.uqbar.commons.utils.TransactionalAndObservable;

@TransactionalAndObservable
public class Pelicula extends Entity {
	public static final String NOMBRE = "nombre";
	public static final String DIRECTOR = "director";
	public static final String GENERO = "genero";

	private static double COSTO = 11;
	private String nombre;
	private String director;
	private String genero;

	public Pelicula() {
	}

	public Pelicula(String nombrePelicula, String nombreDirector) {
		this.nombre = nombrePelicula;
		this.director = nombreDirector;
	}

	public Pelicula(String nombrePelicula, String nombreDirector, String genero) {
		this.nombre = nombrePelicula;
		this.director = nombreDirector;
		this.genero = genero;
	}

	public Pelicula(Integer id) {
		this.setId(id);
	}

	public double getCosto() {
		return Pelicula.COSTO;
	}

	@Override
	public String toString() {
		return this.nombre + " de " + this.director + "genero " + this.genero;
	}

	// ------------------------------------------------------
	// SETTERS Y GETTERS
	public void setDirector(String director) {
		this.director = director;
	}

	public String getDirector() {
		return this.director;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return this.nombre;
	}

	public String getGenero() {
		return this.genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

}
