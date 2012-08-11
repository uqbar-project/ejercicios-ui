package tadp.blocbaster.entidades.mediosDePago;

import tadp.blocbaster.entidades.Pedido;
/**
 * El pago con ticket canasta tiene un monto fijo en pesos de recargo
 * @author Sergio
 *
 */
public class TicketCanasta extends MedioDePago {
	
	public TicketCanasta() {
		this.recargo = 5;
	}
		
	@Override
	public double calcularCosto(Pedido envio) {
		return super.calcularCosto(envio) + this.recargo;
	}
	@Override
	public String toString(){
		return this.getClass().getSimpleName();
	}
}
