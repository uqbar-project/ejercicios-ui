package tadp.blocbaster.entidades.mediosDePago;

import org.uqbar.commons.model.Entity;

import tadp.blocbaster.entidades.Pedido;

public abstract class MedioDePago extends Entity {
	protected double recargo = 0;
	
	public double calcularCosto(Pedido envio) {
		return envio.getCosto();
	}
	public double getRecargo() {
		return this.recargo;
	}
	public void setRecargo(double recargo) {
		this.recargo = recargo;
	}
	
}
