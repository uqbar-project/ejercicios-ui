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
		return generosPosibles;
	}

	public String getGenero() {
		return getExample().getGenero();
	}

	public void setGenero(String genero) {
		getExample().setGenero(genero);
	}
	
	public String getNombre() {
		return getExample().getNombre();
	}
	
	public void setNombre(String nombre) {
		getExample().setNombre(nombre);
	}
	
	public List<Pelicula> getPeliculasPosibles() {
		return searchPeliculas.getResults();
	}
	
	public void buscar() {
		searchPeliculas.search();
	}

	public void limpiar() {
		searchPeliculas.clear();
	}

}