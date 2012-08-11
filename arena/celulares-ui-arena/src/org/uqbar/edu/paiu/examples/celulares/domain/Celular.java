package org.uqbar.edu.paiu.examples.celulares.domain;

import org.uqbar.commons.model.Entity;
import org.uqbar.commons.model.UserException;
import org.uqbar.commons.utils.TransactionalAndObservable;

@TransactionalAndObservable
public class Celular extends Entity {

	private static final long serialVersionUID = -1201175602096523499L;
	public final int MAX_NUMERO = 1000;

	public static final String NOMBRE = "nombre";
	public static final String NUMERO = "numero";
	public static final String RECIBE_CUENTA_DOMICILIO = "recibeResumenCuenta";
	public static final String MODELO_CELULAR = "modeloCelular";

	private Integer numero;
	private String nombre;
	private ModeloCelular modeloCelular;
	private Boolean recibeResumenCuenta;

	public Celular() {
		this.initialize();
	}

	public Celular(String nombre, Integer numero) {
		this.initialize();
		this.nombre = nombre;
		this.numero = numero;
	}

	private void initialize() {
		this.recibeResumenCuenta = false;
	}

	public Celular(String nombre, Integer numero, ModeloCelular modeloCelular, boolean recibeResumenCuenta) {
		this.initialize();
		this.nombre = nombre;
		this.numero = numero;
		this.modeloCelular = modeloCelular;
		this.recibeResumenCuenta = recibeResumenCuenta;
	}

	public Integer getNumero() {
		return this.numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ModeloCelular getModeloCelular() {
		return this.modeloCelular;
	}

	public void setModeloCelular(ModeloCelular modeloCelular) {
		this.modeloCelular = modeloCelular;
	}

	public boolean isRecibeResumenCuenta() {
		return this.recibeResumenCuenta;
	}

	public void setRecibeResumenCuenta(boolean recibeResumenCuenta) {
		this.recibeResumenCuenta = recibeResumenCuenta;
	}

	@Override
	public String toString() {
		StringBuffer result = new StringBuffer();
		if(this.ingresoNombre()) {
			result.append(this.nombre);
		}
		else {
			result.append("Celular sin nombre");
		}
		if(this.modeloCelular != null) {
			result.append(" - " + this.modeloCelular);
		}
		else {
			result.append(" - sin modelo");
		}
		if(this.ingresoNumero()) {
			result.append(" - " + this.numero);
		}
		else {
			result.append(" - sin número");
		}
		if(this.recibeResumenCuenta) {
			result.append(" - recibe resumen de cuenta");
		}
		else {
			result.append(" - no recibe resumen de cuenta");
		}
		return result.toString();
	}

	public String getDescripcionModeloCelular() {
		if(this.getModeloCelular() != null) {
			return this.getModeloCelular().getDescripcion();
		}
		else {
			return null;
		}
	}

	public boolean ingresoNombre() {
		return this.nombre != null && !this.nombre.trim().equals("");
	}

	public boolean ingresoNumero() {
		return this.numero != null;
	}

	/**
	 * valida que el celular esté correctamente cargado
	 */
	public void validar() {
		if(!this.ingresoNumero()) {
			throw new UserException("Debe ingresar número");
		}
		if(this.numero.intValue() <= this.MAX_NUMERO) {
			throw new UserException("El número debe ser mayor a " + this.MAX_NUMERO);
		}
		if(!this.ingresoNombre()) {
			throw new UserException("Debe ingresar nombre");
		}
		if(this.modeloCelular == null) {
			throw new UserException("Debe ingresar un modelo de celular");
		}
	}

	@Override
	public void validateCreate() {
		this.validar();
	}

	public Boolean getRecibeResumenCuenta() {
		return this.recibeResumenCuenta;
	}

	public void setRecibeResumenCuenta(Boolean recibeResumenCuenta) {
		this.recibeResumenCuenta = recibeResumenCuenta;
	}

}
