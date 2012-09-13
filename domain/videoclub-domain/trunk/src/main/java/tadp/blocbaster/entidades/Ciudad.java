/**
 * 
 */
package tadp.blocbaster.entidades;

import org.uqbar.commons.home.db4o.DB4OHomeAutomaticSearch;
import org.uqbar.commons.model.Entity;
import org.uqbar.commons.model.Filter;
import org.uqbar.commons.utils.TransactionalAndObservable;

/**
 * @author jfernandes
 */
@TransactionalAndObservable
public class Ciudad extends Entity {
	@Filter
	private String nombre;

	public Ciudad() {
	}
	
	public Ciudad(String nombre) {
		this.nombre = nombre;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return this.nombre;
	}
	
}
