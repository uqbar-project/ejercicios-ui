package org.uqbar.arena.examples.conversor

import org.uqbar.commons.utils.Observable

@Observable
class Conversor {
	private double millas
	private double kilometros

	// ********************************************************
	// ** Acciones
	// ********************************************************
	
	void convertir() {
		kilometros = millas * 1.60934
	}
	
	// ********************************************************
	// ** Atributos
	// ********************************************************

	double getMillas() {
		this.millas
	}

	void setMillas(double millas) {
		this.millas = millas
	}

	double getKilometros() {
		this.kilometros
	}

	void setKilometros(double kilometros) {
		this.kilometros = kilometros
	}

}
