package uqbar.videoclub.util;

import java.util.HashMap;
import java.util.Map;

import tadp.blocbaster.entidades.mediosDePago.Efectivo;
import tadp.blocbaster.entidades.mediosDePago.MedioDePago;
import tadp.blocbaster.entidades.mediosDePago.TarjetaDeCredito;
import tadp.blocbaster.entidades.mediosDePago.TicketCanasta;

public class MedioPagoUtil {
	public static String EFECTIVO = "1";
	public static String TARJETA_CREDITO = "2";
	public static String TICKET_CANASTA = "3";
	
	private Map<String, MedioDePago> mediosPago;
	
	public MedioPagoUtil() {
		mediosPago = new HashMap<String, MedioDePago>();
		mediosPago.put(EFECTIVO, new Efectivo());
		mediosPago.put(TARJETA_CREDITO, new TarjetaDeCredito());
		mediosPago.put(TICKET_CANASTA, new TicketCanasta());
	}
	
	public MedioDePago getMedioPago(String codigo) {
		if (mediosPago.containsKey(codigo)) {
			return mediosPago.get(codigo);
		} else {
			return null;
		}
	}

}
