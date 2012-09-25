package uqbar.ejemplosBasicos.domain;

import java.io.Serializable;

public class Calculadora implements Serializable {

	private double operando1;
	private double operando2;
	
	public Calculadora() {
	}

	public double sumar() {
		return this.operando1 + this.operando2;
	}

	public double getOperando1() {
		return this.operando1;
	}

	public double getOperando2() {
		return this.operando2;
	}

	public void setOperando1(double operando1) {
		this.operando1 = operando1;
	}

	public void setOperando2(double operando2) {
		this.operando2 = operando2;
	}

	public String getResultado() {
		if (this.getOperando1() != 0 && this.getOperando2() != 0) {
			return "El resultado es " + this.sumar();
		} else {
			return "<Sin datos>";
		}
	}

}
