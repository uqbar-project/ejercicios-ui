package tadp.blocbaster.daos;

import org.uqbar.commons.model.CollectionBasedHome;

import tadp.blocbaster.entidades.Ciudad;

/**
 * 
 * @author nnydjesus
 */
public class CiudadDaoColeccionImpl extends CollectionBasedHome<Ciudad> {

	public CiudadDaoColeccionImpl() {
		this.create(new Ciudad("Quilmes"));
		this.create(new Ciudad("Tandil"));
		this.create(new Ciudad("Carlos Paz"));
		this.create(new Ciudad("Berazategui"));
		this.create(new Ciudad("Capital"));
	}

	@Override
	public Class<Ciudad> getEntityType() {
		return Ciudad.class;
	}

	@Override
	public Ciudad createExample() {
		throw new UnsupportedOperationException("No se puede crear un ejemplo de medio de pago");
	}

	@Override
	protected org.apache.commons.collections15.Predicate getCriterio(Ciudad example) {
		throw new UnsupportedOperationException("CollectionBasedHome<Ciudad>.getCriterio is not implemented yet");
	}

}
