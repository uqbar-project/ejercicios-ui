package org.uqbar.edu.paiu.examples.celulares.dao;

import org.apache.commons.collections15.Predicate;
import org.uqbar.commons.model.CollectionBasedHome;
import org.uqbar.edu.paiu.examples.celulares.domain.ModeloCelular;


public class RepositorioModelos extends CollectionBasedHome<ModeloCelular> {

	private static RepositorioModelos instance;
	
	public static RepositorioModelos getInstance() {
		if (instance == null) {
			instance = new RepositorioModelos();
		}
		return instance;
	}
	
	private RepositorioModelos() {
		this.create(new ModeloCelular("NOKIA 1100", 150));
		this.create(new ModeloCelular("Motorola M90", 350));
		this.create(new ModeloCelular("Ericsson 55", 440));
	}

	@Override
	protected Predicate<ModeloCelular> getCriterio(ModeloCelular example) {
		// TODO: Cambiar para la búsqueda
		return this.getCriterioTodas();
	}

	@Override
	public ModeloCelular createExample() {
		return new ModeloCelular("", 0);
	}

	@Override
	public Class<ModeloCelular> getEntityType() {
		return ModeloCelular.class;
	}
	
}
