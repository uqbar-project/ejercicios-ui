package uqbar.numerosRandom.model;

import java.io.Serializable;
import java.util.Random;

public class GeneradorRandom implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int desde;
	private int hasta;
	private Random random = new Random();
	private int resultado;

	public GeneradorRandom(int desde, int hasta) {
		this.desde = desde;
		this.hasta = hasta;
	}
	
	
	public int getResultado() {
		return resultado;
	}
	
	public void generar() {
		this.resultado = this.random.nextInt(this.hasta - this.desde) + desde;
	}
	
}
