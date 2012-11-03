package uqbar.videoclub.web.stripes.action;

import net.sourceforge.stripes.action.Before;
import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.HandlesEvent;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.action.UrlBinding;
import net.sourceforge.stripes.controller.LifecycleStage;

import org.uqbar.commons.model.Home;

import tadp.blocbaster.daos.Videoclub;
import tadp.blocbaster.entidades.Socio;

/**
 * 
 * @author jfernandes
 */
@UrlBinding("/EditarSocio.htm")
public class EditarSocioActionBean extends BaseActionBean {
	private Socio socio;

	@Before(stages=LifecycleStage.BindingAndValidation)
	public void cargarSocio() {
		Integer id = Integer.valueOf(this.getContext().getRequest().getParameter("id"));
		this.socio = this.getHome().searchById(id);
	}
	
	@DefaultHandler
	public Resolution view() {
		return new ForwardResolution("editar.jsp");
	}
	
	@HandlesEvent("guardar")
	public Resolution guardar() {
		this.getHome().update(this.socio);
		return new ForwardResolution(HomeActionBean.class);
	}

	protected Home<Socio> getHome() {
		return Videoclub.getInstance().getHome(Socio.class);
	}

	public Socio getSocio() {
		return this.socio;
	}

}