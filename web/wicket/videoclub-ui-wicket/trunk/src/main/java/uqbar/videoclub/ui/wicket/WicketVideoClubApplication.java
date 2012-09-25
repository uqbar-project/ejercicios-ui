package uqbar.videoclub.ui.wicket;

import org.apache.wicket.Page;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.protocol.http.WicketServlet;
import org.apache.wicket.settings.IResourceSettings;
import org.apache.wicket.util.resource.locator.IResourceStreamLocator;

import uqbar.videoclub.ui.wicket.pages.ListadoSociosPage;


/**
 * Objeto que representa la unica instancia de la aplicacion wicket. Es parte del disenho de wicket que cada
 * aplicacion tiene que tener un objeto aplicacion. Este objeto se configura en el servlet de wicket. Ver
 * web.xml
 * 
 * La unica responsabilidad obligatoria es indicarle a wicket cual es la clase de la pagina de inicio de
 * nuestra aplicacion.
 * 
 * Luego, desde cualquier pagina o componente wicket se puede acceder a este objeto a traves de
 * {@link WebApplication#get()}
 * 
 * @see WicketServlet
 * 
 * @author jfernandes
 */
public class WicketVideoClubApplication extends WebApplication {

	@Override
	protected void init() {
		super.init();

		// the full path to your folder, relative to the context root
		this.getResourceSettings().addResourceFolder("pages");

		IResourceSettings resourceSettings = getResourceSettings();
		resourceSettings.addResourceFolder("pages");
		resourceSettings.setResourceStreamLocator((IResourceStreamLocator) new PathStripperLocator());
		
	}

	@Override
	public Class<? extends Page> getHomePage() {
		return ListadoSociosPage.class;
	}

}
