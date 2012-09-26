package uqbar.ejemplosBasicos.domain;

import java.io.Serializable;


public class Conversor implements Serializable {
	private static final long serialVersionUID = 3840187612333619620L;
	private double millas=0;;

	// ********************************************************
	// ** Acciones
	// ********************************************************
	
	public double convertir() {
		return this.getMillas() * 1.60934;
	}
	
	// ********************************************************
	// ** Atributos
	// ********************************************************

	public double getMillas() {
		return this.millas;
	}

	public void setMillas(double millas) {
		this.millas = millas;
	}

	public String getResultado() {
		return ""+millas+" millas son: "+ this.convertir()+" kilómetros";
	}

}
