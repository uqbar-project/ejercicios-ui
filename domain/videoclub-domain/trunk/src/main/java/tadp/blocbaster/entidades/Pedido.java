package tadp.blocbaster.entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.uqbar.commons.utils.TransactionalAndObservable;

import tadp.blocbaster.entidades.mediosDePago.MedioDePago;

@TransactionalAndObservable
public class Pedido implements Serializable {
	private List<Pelicula> peliculasParaAlquilar;
	private MedioDePago medioDePago;
	private Date fechaPedido = new Date();

	public Pedido() {
		this.peliculasParaAlquilar = new ArrayList<Pelicula>();
	}

	public Pedido(List<Pelicula> unasPelis, MedioDePago unMedio) {
		this.peliculasParaAlquilar = new ArrayList<Pelicula>();
		this.peliculasParaAlquilar.addAll(unasPelis);
		this.medioDePago = unMedio;
	}

	public double getCosto() {
		double costo = 0;
		for (Pelicula pelicula : this.peliculasParaAlquilar) {
			costo += pelicula.getCosto();
		}
		return costo;
	}

	@Override
	public String toString() {
		return "\nMedio de Pago: " + this.medioDePago + ".\n" + "Peliculas: "
			+ this.peliculasParaAlquilar;

	}

	// ----------------------------------------------------------
	// SETTERS Y GETTERS

	public void setMedioDePago(MedioDePago medioDePago) {
		this.medioDePago = medioDePago;
	}

	public MedioDePago getMedioDePago() {
		return this.medioDePago;
	}

	public void setPeliculasParaAlquilar(List<Pelicula> peliculasParaAlquilar) {
		this.peliculasParaAlquilar = peliculasParaAlquilar;
	}

	public List<Pelicula> getPeliculasParaAlquilar() {
		return this.peliculasParaAlquilar;
	}

	public void addPelicula(Pelicula unaBuenaPelicula) {
		this.peliculasParaAlquilar.add(unaBuenaPelicula);
	}

	public Date getFechaPedido() {
		return this.fechaPedido;
	}

	public void setFechaPedido(Date fechaPedido) {
		this.fechaPedido = fechaPedido;
	}

}
