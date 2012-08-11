package tadp.blocbaster.entidades.mediosDePago;

import tadp.blocbaster.entidades.Pedido;
/**
 * El pago con tarjeta tiene un recargo de 5 %
 * @author Sergio
 *
 */
public class TarjetaDeCredito extends MedioDePago {
	
	public TarjetaDeCredito() {
		this.recargo = 1.05;
	}
	public TarjetaDeCredito(double recargo){
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
