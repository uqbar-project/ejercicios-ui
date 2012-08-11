package tadp.blocbaster.daos;

import org.apache.commons.collections15.Predicate;
import org.uqbar.commons.model.CollectionBasedHome;

import tadp.blocbaster.entidades.mediosDePago.Efectivo;
import tadp.blocbaster.entidades.mediosDePago.MedioDePago;
import tadp.blocbaster.entidades.mediosDePago.TarjetaDeCredito;
import tadp.blocbaster.entidades.mediosDePago.TicketCanasta;

/**
 * 
 * @author npasserini
 */
public class MedioDePagoDaoColeccionImpl extends CollectionBasedHome<MedioDePago> {

	public MedioDePagoDaoColeccionImpl() {
		this.create(new Efectivo());
		this.create(new TarjetaDeCredito());
		this.create(new TicketCanasta());
	}

	@Override
	public Class<MedioDePago> getEntityType() {
		return MedioDePago.class;
	}

	@Override
	public MedioDePago createExample() {
		throw new UnsupportedOperationException("No se puede crear un ejemplo de medio de pago");
	}

	@Override
	protected Predicate getCriterio(MedioDePago example) {
		throw new UnsupportedOperationException("No se puede crear un criterio para buscar medios de pago");
	}

}
