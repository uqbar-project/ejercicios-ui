package tadp.blocbaster.daos;

import org.apache.commons.collections15.Predicate;
import org.uqbar.commons.model.CollectionBasedHome;

import tadp.blocbaster.entidades.Socio;

/**
 * @author npasserini
 */
public class SocioDaoColeccionImpl extends CollectionBasedHome<Socio> {

	// ********************************************************
	// ** Constructor
	// ********************************************************

	public SocioDaoColeccionImpl() {
		this.create(new Socio("Fernando Dodino", "Nazca 333", "fer", "fer"));
		this.create(new Socio("Nicolas Passerini", "Urquiza 444", "nico", "nico"));
		this.create(new Socio("Debora Fortini", "Medrano 555", "deby", "deby"));
		this.create(new Socio("Sergio Magnacco", "urquiza 553", "ser", "ser"));
	}

	@Override
	public Class<Socio> getEntityType() {
		return Socio.class;
	}

	@Override
	public Socio createExample() {
		return new Socio();
	}

	// ********************************************************
	// ** Criterios de búsqueda específicos
	// ********************************************************

	@Override
	public org.apache.commons.collections15.Predicate getCriterio(final Socio clienteBuscado) {
		String nombre = clienteBuscado.getNombre();
		String direccion = clienteBuscado.getDireccion();
		Integer id = clienteBuscado.getId();

		if (id != null) {
			return this.getCriterioPorId(id);
		}

		if (nombre != null && direccion != null) {
			if (nombre.equals("") && direccion.equals("")) {
				return this.getCriterioTodas();
			} else {
				return this.getCriterioClientePorNombreYDireccion(clienteBuscado);
			}
		}

		if (nombre != null) {
			return this.getCriterioClientePorNombre(clienteBuscado);
		}

		if (direccion != null) {
			return this.getCriterioClientePorDireccion(clienteBuscado);
		}

		return this.getCriterioTodas();
	}

	protected org.apache.commons.collections15.Predicate getCriterioClientePorDireccion(final Socio clienteBuscado) {
		return new Predicate() {
			@Override
			public boolean evaluate(Object arg) {
				Socio unCliente = (Socio) arg;
				return unCliente.getDireccion().toLowerCase().contains(clienteBuscado.getDireccion().toLowerCase());
			}
		};
	}

	protected org.apache.commons.collections15.Predicate getCriterioClientePorNombreYDireccion(
			final Socio clienteBuscado) {
		return new Predicate() {
			@Override
			public boolean evaluate(Object arg) {
				Socio unCliente = (Socio) arg;
				return unCliente.getNombre().toLowerCase().contains(clienteBuscado.getNombre().toLowerCase())
						&& unCliente.getDireccion().toLowerCase().contains(clienteBuscado.getDireccion().toLowerCase());
			}
		};
	}

	protected Predicate getCriterioClientePorNombre(final Socio clienteBuscado) {
		return new Predicate() {
			@Override
			public boolean evaluate(Object arg) {
				Socio unCliente = (Socio) arg;
				return unCliente.getNombre().toLowerCase().contains(clienteBuscado.getNombre().toLowerCase());
			}
		};
	}
}
