package org.uqbar.edu.paiu.examples.celulares.ui.arena;

import org.uqbar.commons.model.Home;
import org.uqbar.commons.model.SearchByExample;
import org.uqbar.commons.utils.TransactionalAndObservable;
import org.uqbar.edu.paiu.examples.celulares.domain.Celular;

@SuppressWarnings("serial")
@TransactionalAndObservable
public class BuscadorCelular extends SearchByExample<Celular> {

	public BuscadorCelular(Home<Celular> home) {
		super(home);
	}

	public void setNombre(String nombre) {
		this.getExample().setNombre(nombre);
	}

	public void setNumero(Integer numero) {
		this.getExample().setNumero(numero);
	}

	/** 
	 * Getters necesarios para que funcione el ejemplo de wicket
	 */
	public String getNombre() {
		return this.getExample().getNombre();
	}

	public Integer getNumero() {
		return this.getExample().getNumero();
	}

	/**
	 * Fin getters necesarios
	 */
	
	@Override
	public void clear() {
		this.setNombre("");
		this.setNumero(null);
	}
	
}
