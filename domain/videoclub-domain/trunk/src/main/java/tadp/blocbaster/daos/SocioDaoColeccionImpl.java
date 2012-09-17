package tadp.blocbaster.daos;

import org.apache.commons.collections15.Predicate;
import org.apache.commons.collections15.functors.AndPredicate;
import org.uqbar.commons.model.CollectionBasedHome;

import tadp.blocbaster.entidades.Socio;
import tadp.blocbaster.entidades.Socio.Estado;

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
		Socio sergio = new Socio("Sergio Magnacco", "urquiza 553", "ser", "ser");
		sergio.setEstado(Estado.INACTIVO);
		this.create(sergio);
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
	public Predicate<Socio> getCriterio(final Socio socioBuscado) {
		Predicate<Socio> resultPredicate = this.getCriterioTodas();
		
		String nombre = socioBuscado.getNombre();
		String direccion = socioBuscado.getDireccion();
		Integer id = socioBuscado.getId();
		Estado estado = socioBuscado.getEstado();
		
		if (id != null) {
			resultPredicate = new AndPredicate<Socio>(resultPredicate, this.getCriterioPorId(id));
		}
		
		if (nombre != null) {
			resultPredicate = new AndPredicate<Socio>(resultPredicate, this.getCriterioClientePorNombre(socioBuscado));
		}

		if (direccion != null) {
			resultPredicate = new AndPredicate<Socio>(resultPredicate, this.getCriterioClientePorDireccion(socioBuscado));
		}
		
		if (estado != null) {
			resultPredicate = new AndPredicate<Socio>(resultPredicate, this.getCriterioClientePorEstado(socioBuscado));
		}

		return resultPredicate;
	}

	protected Predicate<Socio> getCriterioClientePorDireccion(final Socio clienteBuscado) {
		return new Predicate() {
			@Override
			public boolean evaluate(Object arg) {
				Socio unSocio = (Socio) arg;
				return unSocio.getDireccion().toLowerCase().contains(clienteBuscado.getDireccion().toLowerCase());
			}
		};
	}

	protected Predicate<Socio> getCriterioClientePorNombre(final Socio clienteBuscado) {
		return new Predicate() {
			@Override
			public boolean evaluate(Object arg) {
				Socio unSocio = (Socio) arg;
				return unSocio.getNombre().toLowerCase().contains(clienteBuscado.getNombre().toLowerCase());
			}
		};
	}
	
	private Predicate<Socio> getCriterioClientePorEstado(final Socio clienteBuscado) {
		return new Predicate() {
			@Override
			public boolean evaluate(Object arg) {
				Socio unSocio = (Socio) arg;
				return unSocio.getEstado() == null || unSocio.getEstado().equals(clienteBuscado.getEstado());
			}
		};
	}
	
}

