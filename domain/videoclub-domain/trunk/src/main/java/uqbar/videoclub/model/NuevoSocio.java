package uqbar.videoclub.model;

import tadp.blocbaster.entidades.Socio;

/**
 * Modelo para la creación de un socio.
 * 
 * @author jfernandes
 */
public class NuevoSocio extends AbstractVideoClubObject {
	private String nombre;
	private String direccion;
	private ListadoSocios listado;

	public NuevoSocio(ListadoSocios listado) {
		this.listado = listado;
	}

	public void aceptar() {
		this.listado.agregar(new Socio(this.nombre, this.direccion));
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
}
