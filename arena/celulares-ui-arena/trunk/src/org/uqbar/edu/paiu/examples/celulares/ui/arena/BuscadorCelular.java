package org.uqbar.edu.paiu.examples.celulares.ui.arena;

import java.util.List;

import org.uqbar.commons.utils.Observable;
import org.uqbar.edu.paiu.examples.celulares.dao.RepositorioCelulares;
import org.uqbar.edu.paiu.examples.celulares.domain.Celular;

@SuppressWarnings("serial")
@Observable
public class BuscadorCelular {
	private Integer numero;
	private String nombre;
	private List<Celular> resultados;
	private Celular celularSeleccionado;

	// ********************************************************
	// ** Acciones
	// ********************************************************

	public void search() {
		this.resultados = RepositorioCelulares.getInstance().search(this.numero, this.nombre);
	}

	public void clear() {
		this.nombre = "";
		this.numero = null;
	}

	public void eliminarCelularSeleccionado() {
		RepositorioCelulares.getInstance().delete(this.getCelularSeleccionado());
		this.search();
	}

	// ********************************************************
	// ** Accessors
	// ********************************************************

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Celular getCelularSeleccionado() {
		return celularSeleccionado;
	}

	public void setCelularSeleccionado(Celular celularSeleccionado) {
		this.celularSeleccionado = celularSeleccionado;
	}

	public List<Celular> getResultados() {
		return resultados;
	}

	public void setResultados(List<Celular> resultados) {
		this.resultados = resultados;
	}
}
