package tadp.blocbaster.daos;

import org.uqbar.commons.model.Entity;
import org.uqbar.commons.model.ObjectSet;

import tadp.blocbaster.entidades.Ciudad;

/**
 * Crea objetos "default" del dominio de la aplicacion
 * 
 * @author jfernandes
 */
public class VideoclubObjectSets extends ObjectSet {

	@Override
	protected Entity[] createSimpleObjects() {
		return new Entity[] {
				new Ciudad("Capital Federal"),
				new Ciudad("Junin"),
				new Ciudad("Quilmes"),
				new Ciudad("Tandil"),
				new Ciudad("Mar del Plata")
		};
	}
	
	public static void main(String[] args) {
		new VideoclubObjectSets().execute(Videoclub.initialize());
	}
	
}
