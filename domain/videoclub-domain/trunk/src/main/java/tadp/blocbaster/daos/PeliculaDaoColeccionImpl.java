package tadp.blocbaster.daos;

import org.apache.commons.collections15.Predicate;
import org.uqbar.commons.model.CollectionBasedHome;

import tadp.blocbaster.entidades.Pelicula;

/**
 * @author Sergio
 */
public class PeliculaDaoColeccionImpl extends CollectionBasedHome<Pelicula> {

	public PeliculaDaoColeccionImpl() {
		this.create(new Pelicula("El señor de los anillos 1", "Peter Jackson", "Epica"));
		this.create(new Pelicula("El señor de los anillos 2", "Peter Jackson", "Epica"));
		this.create(new Pelicula("El señor de los anillos 3", "Peter Jackson", "Epica"));
		this.create(new Pelicula("Matrix 1", "Wachowski Brothers", "Ciencia Ficcion"));
		this.create(new Pelicula("Matrix 2 - Reloaded", "Wachowski Brothers", "Ciencia Ficcion"));
		this.create(new Pelicula("Matrix 3 - Revolutions", "Wachowski Brothers", "Ciencia Ficcion"));
		this.create(new Pelicula("Corazon Valiente", "Mel Gibson", "Epica"));
		this.create(new Pelicula("El Patriota", "Mel Gibson", "Guerra"));
		this.create(new Pelicula("Alien 1", "Ridley Scott", "Alienigenas"));
		this.create(new Pelicula("Aliens 2", "James Cameron", "Alienigenas"));
		this.create(new Pelicula("Alien 3", "David Fincher", "Alienigenas"));
		this.create(new Pelicula("Alien Resurrection 4", "Jan Pierre Jeunet", "Alienigenas"));
		this.create(new Pelicula("Soy Leyenda", "Espilber", "Ciencia Ficcion"));
		this.create(new Pelicula("REC", "Jaume Balaquero", "TERROR(muejeje)"));
	}

	@Override
	public Class<Pelicula> getEntityType() {
		return Pelicula.class;
	}

	@Override
	public Pelicula createExample() {
		return new Pelicula();
	}

	@Override
	public Predicate getCriterio(Pelicula peliculaBuscada) {
		String nombrePelicula = peliculaBuscada.getNombre();
		String director = peliculaBuscada.getDirector();
		String genero = peliculaBuscada.getGenero();
		Integer id = peliculaBuscada.getId();
		if (id != null) {
			return this.getCriterioPorId(id);
		}
		if (nombrePelicula != null && director != null && genero != null) {
			if (nombrePelicula.equals("") && director.equals("") && genero.equals("")) {
				return this.getCriterioTodas();
			} else {
				return this.getCriterioDePeliculaPorNombreDirectorGenero(peliculaBuscada);
				// getCriterioDePeliculaPorNombreYDirector(peliculaBuscada);
			}
		}
		if (nombrePelicula != null && director != null && (genero == null || genero.equals(""))) {
			if (nombrePelicula.equals("") && director.equals("")) {
				return this.getCriterioTodas();
			} else {
				return this.getCriterioDePeliculaPorNombreYDirector(peliculaBuscada);
			}
		}
		if (genero == null) {
			if (nombrePelicula != null) {
				return this.getCriterioDePeliculaPorNombre(peliculaBuscada);
			}
			if (director != null) {
				return this.getCriterioDePeliculaPorDirector(peliculaBuscada);
			}
		} else {
			if (nombrePelicula != null) {
				return this.getCriterioDePeliculaPorNombreYGenero(peliculaBuscada);
			}
			if (director != null) {
				return this.getCriterioDePeliculaPorDirectorYGenero(peliculaBuscada);
			}
			if (nombrePelicula == null && director == null) {
				return this.getCriterioDePeliculaPorGenero(peliculaBuscada);
			}
		}
		return this.getCriterioTodas();
	}

	protected Predicate getCriterioDePeliculaPorGenero(final Pelicula peliculaBuscada) {
		return new Predicate() {
			@Override
			public boolean evaluate(Object arg) {
				Pelicula unaPelicula = (Pelicula) arg;
				return unaPelicula.getGenero().toLowerCase().contains(peliculaBuscada.getGenero().toLowerCase());
			}
		};
	}

	protected Predicate getCriterioDePeliculaPorNombreYGenero(final Pelicula peliculaBuscada) {
		return new Predicate() {
			@Override
			public boolean evaluate(Object arg) {
				Pelicula unaPelicula = (Pelicula) arg;
				return unaPelicula.getNombre().toLowerCase().contains(peliculaBuscada.getNombre().toLowerCase())
						&& unaPelicula.getGenero().toLowerCase().contains(peliculaBuscada.getGenero().toLowerCase());
			}
		};
	}

	protected Predicate getCriterioDePeliculaPorDirectorYGenero(final Pelicula peliculaBuscada) {
		return new Predicate() {
			@Override
			public boolean evaluate(Object arg) {
				Pelicula unaPelicula = (Pelicula) arg;
				return unaPelicula.getDirector().toLowerCase().contains(peliculaBuscada.getDirector().toLowerCase())
						&& unaPelicula.getGenero().toLowerCase().contains(peliculaBuscada.getGenero().toLowerCase());
			}
		};

	}

	protected Predicate getCriterioDePeliculaPorNombreDirectorGenero(final Pelicula peliculaBuscada) {
		return new Predicate() {
			@Override
			public boolean evaluate(Object arg) {
				Pelicula unaPelicula = (Pelicula) arg;
				return unaPelicula.getNombre().toLowerCase().contains(peliculaBuscada.getNombre().toLowerCase())
						&& unaPelicula.getDirector().toLowerCase()
								.contains(peliculaBuscada.getDirector().toLowerCase())
						&& unaPelicula.getGenero().toLowerCase().contains(peliculaBuscada.getGenero().toLowerCase());
			}
		};

	}

	protected Predicate getCriterioDePeliculaPorDirector(final Pelicula peliculaBuscada) {
		return new Predicate() {
			@Override
			public boolean evaluate(Object arg) {
				Pelicula unaPelicula = (Pelicula) arg;
				return unaPelicula.getDirector().toLowerCase().contains(peliculaBuscada.getDirector().toLowerCase());
			}
		};
	}

	protected Predicate getCriterioDePeliculaPorNombre(final Pelicula peliculaBuscada) {
		return new Predicate() {
			@Override
			public boolean evaluate(Object arg) {
				Pelicula unaPelicula = (Pelicula) arg;
				return unaPelicula.getNombre().toLowerCase().contains(peliculaBuscada.getNombre().toLowerCase());
			}
		};
	}

	protected Predicate getCriterioDePeliculaPorNombreYDirector(final Pelicula peliculaBuscada) {
		return new Predicate() {
			@Override
			public boolean evaluate(Object arg) {
				Pelicula unaPelicula = (Pelicula) arg;
				return unaPelicula.getNombre().toLowerCase().contains(peliculaBuscada.getNombre().toLowerCase())
						&& unaPelicula.getDirector().toLowerCase()
								.contains(peliculaBuscada.getDirector().toLowerCase());
			}
		};
	}
}
