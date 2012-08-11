package tadp.blocbaster.daos;

import java.util.Map;

import org.uqbar.commons.home.db4o.DB4OHomeAutomaticSearch;
import org.uqbar.commons.home.db4o.DB4OHomeImpl;
import org.uqbar.commons.model.Home;

import tadp.blocbaster.entidades.Ciudad;
import tadp.blocbaster.entidades.Pelicula;
import tadp.blocbaster.entidades.Socio;
import tadp.blocbaster.entidades.mediosDePago.MedioDePago;

/**
 * Implementacion default que usa las homes de db4o para persistir en una bd de objetos.
 * 
 * @author jfernandes
 */
public class DefaultPersistentHomeFactory implements HomeFactory {

	@Override
	public void addHomes(Map<Class<?>, Home<?>> homes) {
		this.addHome(homes, 
				Socio.class, 
				MedioDePago.class, 
				Pelicula.class,
				Ciudad.class);
	}

	private void addHome(Map<Class<?>, Home<?>> homes, Class... entityType) {
		for (Class clazz : entityType) {
			homes.put(clazz, this.createHome(clazz));
		}
	}

	protected DB4OHomeImpl createHome(Class clazz) {
		return new DB4OHomeAutomaticSearch(clazz);
	}

}
