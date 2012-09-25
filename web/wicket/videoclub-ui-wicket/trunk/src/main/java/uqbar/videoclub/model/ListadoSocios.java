package uqbar.videoclub.model;

import java.util.List;

import org.uqbar.commons.model.Home;

import tadp.blocbaster.daos.Videoclub;
import tadp.blocbaster.entidades.Socio;

/**
 * Modela el caso de uso del listado de socios que permite realizar la busqueda de los mismos a traves de:
 * nombre y/o direccion.
 * 
 * Es independiente de la tecnologia (wicket, swt, etc.).
 * 
 * Tiene la responsabilidad de:
 * <ol>
 * <li>Mantener el estado del criterio de busqueda del usuario: {@link #nombre}, {@link #direccion}</li>
 * <li>Sabe ejecutar la busqueda propiamente dicha a partir de los valores de los campos: {@link #buscar()}</li>
 * <li>Mantiene el estado del resultado de la busqueda: {@link #resultado}</li>
 * </ol>
 * 
 * En definitiva es la representacion en objetos del modelo mental del usuario cuando usa este 'caso de uso'
 * de nuestra aplicacion. Hay una asociacion directa entre este objeto: su estado y comportamiento; y lo que
 * usuario ve y puede hacer desde esta pantalla. Independientemente de la tecnologia, vista y controllers.
 * 
 * @author jfernandes
 */
public class ListadoSocios extends AbstractVideoClubObject {
	private String nombre;
	private String direccion;
	private List<Socio> resultado;

	public void buscar() {
		this.resultado = this.getHome().searchByExample(this.getExample());
	}

	protected Socio getExample() {
		return new Socio(this.getNombre(), this.getDireccion());
	}

	public void limpiar() {
		this.resultado.clear();
	}

	public void agregar(Socio socio) {
		this.getHome().create(socio);
		this.buscar();
	}

	public void eliminar(Socio socio) {
		this.resultado.remove(socio);
		this.getHome().delete(socio);
	}

	// ********************************************************
	// ** Internal
	// ********************************************************

	protected Home<Socio> getHome() {
		return Videoclub.getInstance().getHome(Socio.class);
	}

	// ********************************************************
	// ** Accessors
	// ********************************************************

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public List<Socio> getResultado() {
		return this.resultado;
	}

}