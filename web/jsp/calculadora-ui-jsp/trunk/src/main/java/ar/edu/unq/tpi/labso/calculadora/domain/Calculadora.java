package ar.edu.unq.tpi.labso.calculadora.domain;

public class Calculadora {
	
	private final double arg1;
	private final double arg2;
	
	public Calculadora(double arg1, double arg2) {
		this.arg1 = arg1;
		this.arg2 = arg2;
	}

	public double sumar() {
		return this.arg1 + this.arg2;
	}

}
