package uqbar.videoclub.model;

import java.util.List;

import org.uqbar.commons.model.SearchByExample;

import tadp.blocbaster.daos.PeliculaDaoColeccionImpl;
import tadp.blocbaster.daos.Videoclub;
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
	private List<String> generosPosibles;
	private SearchByExample<Pelicula> searchPeliculas;
	private Pedido pedido = new Pedido();

	public AlquilarPeliculas(Socio socio) {
		super();
		this.socio = socio;
		this.generosPosibles = Videoclub.getInstance().getGeneros();
		this.searchPeliculas = new SearchByExample<Pelicula>(new PeliculaDaoColeccionImpl());
	}

	/********************************************************************
	 * ALQUILAR
	 ********************************************************************/
	public Socio getSocio() {
		return this.socio;
	}

	public Pedido getPedido() {
		return this.pedido;
	}

	public void alquilarPelicula(Pelicula pelicula) {
		this.getPedido().addPelicula(pelicula);
	}

	/*******************************************************************
	 * FORMULARIO DE BUSQUEDA
	 ******************************************************************/
	
	private Pelicula getExample() {
		return this.searchPeliculas.getExample();
	}

	public List<String> getGenerosPosibles() {
		return this.generosPosibles;
	}

	public String getGenero() {
		return this.getExample().getGenero();
	}

	public void setGenero(String genero) {
		this.getExample().setGenero(genero);
	}
	
	public String getNombre() {
		return this.getExample().getNombre();
	}
	
	public void setNombre(String nombre) {
		this.getExample().setNombre(nombre);
	}
	
	public List<Pelicula> getPeliculasPosibles() {
		return this.searchPeliculas.getResults();
	}
	
	public void buscar() {
		this.searchPeliculas.search();
	}

	public void limpiar() {
		this.searchPeliculas.clear();
	}

}