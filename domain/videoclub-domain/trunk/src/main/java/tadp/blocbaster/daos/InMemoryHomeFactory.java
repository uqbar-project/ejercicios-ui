package tadp.blocbaster.daos;

import java.util.Map;

import org.uqbar.commons.model.Home;

import tadp.blocbaster.entidades.Ciudad;
import tadp.blocbaster.entidades.Pelicula;
import tadp.blocbaster.entidades.Socio;
import tadp.blocbaster.entidades.mediosDePago.MedioDePago;

/**
 * Implementacion dummy que crea las homes en-memoria
 * 
 * @author jfernandes
 */
public class InMemoryHomeFactory implements HomeFactory {

	@Override
	public void addHomes(Map<Class<?>, Home<?>> homes) {
		homes.put(Socio.class, new SocioDaoColeccionImpl());
		homes.put(MedioDePago.class, new MedioDePagoDaoColeccionImpl());
		homes.put(Pelicula.class, new PeliculaDaoColeccionImpl());
		homes.put(Ciudad.class, new CiudadDaoColeccionImpl());
	}

}
