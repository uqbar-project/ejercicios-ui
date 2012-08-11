package tadp.blocbaster.entidades.mediosDePago;

import tadp.blocbaster.entidades.Pedido;

public class Efectivo extends MedioDePago {
	public Efectivo() {
		this.recargo = 0.9;
	}
	public Efectivo(double recargo){
		this.recargo = recargo;
	}
	
	@Override
	public double calcularCosto(Pedido envio) {
		return super.calcularCosto(envio) * this.recargo;

	}

	@Override
	public String toString(){
		return this.getClass().getSimpleName();
	}
}
