package tadp.blocbaster.entidades;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.uqbar.commons.model.Entity;
import org.uqbar.commons.model.Filter;
import org.uqbar.commons.model.UserException;
import org.uqbar.commons.utils.TransactionalAndObservable;

/**
 * Representa un socio del VideoClub
 * 
 * @author npasserini
 */
@TransactionalAndObservable
public class Socio extends Entity {
	public static final String DIRECCION = "direccion";
	public static final String NOMBRE = "nombre";
	public static final String FECHA_INGRESO = "fecha";

	@Filter
	private String nombre;
	@Filter
	private String direccion;
	private Date fecha;
	private Ciudad ciudad;
	private List<Pedido> pedidos = new ArrayList<Pedido>();
	@Filter
	private Estado estado;

	// para el find by example
	public Socio() {
	}

	public Socio(String nombre, String direccion) {
		this.nombre = nombre;
		this.direccion = direccion;
	}

	public Socio(String nombre, String direccion, String usuario, String contrasena) {
		this.nombre = nombre;
		this.direccion = direccion;
		this.fecha = new Date();
	}

	public Socio(Integer idCliente) {
		this.setId(idCliente);
	}

	// *************************************
	// ** Validaciones
	// *************************************

	@Override
	public void validateCreate() {
		if (this.getNombre() == null) {
			throw new UserException("El socio debe tener un nombre no vacío.");
		}
		if (this.getDireccion() == null) {
			throw new UserException("La fecha de ingreso no puede ser vacía.");
		}
	}

	@Override
	public void validateDelete() {
		if (this.pedidos != null && !this.getPedidos().isEmpty()) {
			throw new UserException("No se puede eliminar el Socio porque tiene pedidos");
		}
	}

	// ********************************************************
	// ** Acciones
	// ********************************************************

	public void addPedido(Pedido pedido) {
		this.pedidos.add(pedido);
	}

	// ********************************************************
	// ** Atributos
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

	public List<Pedido> getPedidos() {
		return this.pedidos;
	}

	public void setFecha(Date fecha) {
		if (fecha == null) {
			throw new UserException("Ingrese una fecha válida");
		}
		else if (fecha.after(new Date())) {
			throw new UserException("La fecha de ingreso debe ser anterior a la actual");
		}

		this.fecha = fecha;
	}

	public Date getFecha() {
		return this.fecha;
	}
	
	public Ciudad getCiudad() {
		return this.ciudad;
	}
	
	public void setCiudad(Ciudad ciudad) {
		this.ciudad = ciudad;
	}
	
	public Estado getEstado() {
		return this.estado;
	}
	
	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	// ********************************************************
	// ** Misceláneos
	// ********************************************************

	@Override
	public String toString() {
		return this.nombre + " direccion: " + this.direccion + " fecha: " + this.fecha;
	}
	
	/**
	 * 
	 * @author jfernandes
	 */
	public enum Estado {
		ACTIVO("Activo"),
		INACTIVO("Inactivo");
		
		private String nombre;
		
		private Estado(String nombre) {
			this.nombre = nombre;
		}
		
		public String getNombre() {
			return this.nombre;
		}
	}
	
}
