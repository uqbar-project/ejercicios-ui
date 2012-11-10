package uqbar.calculadora.domain;

import java.io.Serializable;

public class Calculadora implements Serializable {

	private double sumando1;
	private double sumando2;
	
	public Calculadora() {
	}

	public double sumar() {
		return this.sumando1 + this.sumando2;
	}

	public double getSumando1() {
		return this.sumando1;
	}

	public double getSumando2() {
		return this.sumando2;
	}

	public void setSumando1(double sumando1) {
		this.sumando1 = sumando1;
	}

	public void setSumando2(double sumando2) {
		this.sumando2 = sumando2;
	}

	public String getResultado() {
		if (this.getSumando1() != 0 && this.getSumando2() != 0) {
			return "El resultado es " + this.sumar();
		} else {
			return "<Sin datos>";
		}
	}

}
