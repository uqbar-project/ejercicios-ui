package org.uqbar.edu.paiu.examples.celulares.dao;

import java.io.Serializable;
import java.util.Iterator;

import org.apache.commons.collections15.Predicate;
import org.apache.commons.collections15.functors.AndPredicate;
import org.uqbar.commons.model.CollectionBasedHome;
import org.uqbar.commons.model.UserException;
import org.uqbar.edu.paiu.examples.celulares.domain.Celular;

public class RepositorioCelulares extends CollectionBasedHome<Celular> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static RepositorioCelulares instance;

	@Override
	protected Predicate<Celular> getCriterio(Celular example) {
		Predicate<Celular> resultPredicate = this.getCriterioTodas();
		if (example.ingresoNombre()) {
			resultPredicate = new AndPredicate<Celular>(resultPredicate, this.getCriterioPorNombre(example));
		}
		if (example.ingresoNumero()) {
			resultPredicate = new AndPredicate<Celular>(resultPredicate, this.getCriterioPorNumero(example));
		}
		return resultPredicate;
	}

	protected Predicate<Celular> getCriterioPorNombre(final Celular celularBuscado) {
		return new Predicate<Celular>() {
			@Override
			public boolean evaluate(Celular unCelular) {
				return unCelular.getNombre().toLowerCase().contains(celularBuscado.getNombre().toLowerCase());
			}
		};
	}

	protected Predicate<Celular> getCriterioPorNumero(final Celular celularBuscado) {
		return new Predicate<Celular>() {
			@Override
			public boolean evaluate(Celular unCelular) {
				return unCelular.getNumero() == null || unCelular.getNumero().equals(celularBuscado.getNumero());
			}
		};
	}
	
	@Override
	public Celular createExample() {
		return new Celular();
	}

	@Override
	public Class<Celular> getEntityType() {
		return Celular.class;
	}

	private RepositorioCelulares() {
		super();
		this.create(new Celular("Natalia", new Integer(1588022202), RepositorioModelos.getInstance().allInstances().iterator().next(), false));
		Celular celuDiana = new Celular("Bernardo", new Integer(1566378124), RepositorioModelos.getInstance().allInstances().iterator().next(), true);
		this.create(celuDiana);
	}

	public static RepositorioCelulares getInstance() {
		if (instance == null) {
			instance = new RepositorioCelulares();
		}
		return instance;
	}

	@Override
	public void validateCreate(Celular celular) {
		super.validateCreate(celular);
		this.validarClientesDuplicados(celular);
	}

	private void validarClientesDuplicados(Celular celular) {
		Iterator<Celular> it = this.searchByExample(new Celular(null, celular.getNumero())).iterator();
		while (it.hasNext()) {
			Celular otro = it.next();
			if (!otro.getId().equals(celular.getId())) {
				throw new UserException("El cliente " + otro.getNombre() + " tiene el mismo número");
			}
		}
	}
	
	@Override
	public void update(Celular celular) {
		celular.validar();
		this.validarClientesDuplicados(celular);
		super.update(celular);
	}

}
