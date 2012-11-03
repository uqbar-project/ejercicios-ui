package uqbar.videoclub.web.stripes.action;

import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.HandlesEvent;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.action.SessionScope;
import net.sourceforge.stripes.action.UrlBinding;
import tadp.blocbaster.entidades.Socio;
import uqbar.videoclub.model.ListadoSocios;

/**
 * @author jfernandes
 */
@UrlBinding("/Home.htm")
@SessionScope
public class HomeActionBean extends BaseActionBean {
	private ListadoSocios listadoSocios;
	private Integer idSocioSeleccionado;
	
	public HomeActionBean() {
		this.listadoSocios = new ListadoSocios();
	}

    @DefaultHandler
    public Resolution view() {
    	this.listadoSocios.buscar();
        return new ForwardResolution("/home.jsp");
    }
    
    @HandlesEvent("limpiar")
    public Resolution limpiar() {
    	this.listadoSocios.setNombre(null);
    	this.listadoSocios.setDireccion(null);
    	return this.view();
    }
    
    @HandlesEvent("delete")
    public Resolution eliminar() {
    	this.listadoSocios.eliminar(this.getSocioSeleccionado());
    	return this.view();
    }
    
    protected Socio getSocioSeleccionado() {
    	for (Socio socio : this.listadoSocios.getResultado()) {
			if (socio.getId().equals(this.idSocioSeleccionado)) {
				return socio;
			}
		}
		throw new RuntimeException("No existe el socio con id [" + this.idSocioSeleccionado + "]");
	}

	public ListadoSocios getListadoSocios() {
        return this.listadoSocios;
    }
    
    public Integer getIdSocioSeleccionado() {
		return idSocioSeleccionado;
	}
    
    public void setIdSocioSeleccionado(Integer idSocioSeleccionado) {
		this.idSocioSeleccionado = idSocioSeleccionado;
	}

}