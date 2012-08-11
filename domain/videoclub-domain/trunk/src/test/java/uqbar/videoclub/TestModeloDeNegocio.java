package uqbar.videoclub;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.uqbar.commons.model.Entity;

import tadp.blocbaster.daos.InMemoryHomeFactory;
import tadp.blocbaster.daos.Videoclub;
import tadp.blocbaster.entidades.Pelicula;
import tadp.blocbaster.entidades.Socio;
import tadp.blocbaster.entidades.mediosDePago.MedioDePago;

/**
 * Test del modelo de negocio del video blocbaster
 * 
 * @author Sergio
 */
public abstract class TestModeloDeNegocio<T extends Entity> {
	protected List<Pelicula> pelis;
	protected Pelicula unaPeliculaDeAccion, unaPeliculaDeMiedo;
	protected Socio unSocio;
	protected MedioDePago unMedioDePago;

	@Before
	public void setUp() {
		Videoclub.initialize(new InMemoryHomeFactory());

		this.pelis = new ArrayList<Pelicula>();
		this.unaPeliculaDeAccion = Videoclub.getInstance().getHome(Pelicula.class).searchById(1);
		this.pelis.add(this.unaPeliculaDeAccion);
		this.unaPeliculaDeMiedo = Videoclub.getInstance().getHome(Pelicula.class).searchById(2);
		this.pelis.add(this.unaPeliculaDeMiedo);
		this.unSocio = Videoclub.getInstance().getHome(Socio.class).searchById(2);
		this.unMedioDePago = Videoclub.getInstance().getHome(MedioDePago.class).searchById(1);
	}

	@After
	public void tearDown() {
	}

	// ************************************
	// ** helper methods
	// ************************************

	protected void assertFindByExample(T example, int expectedCount) {
		assertEquals("No encontró a los clientes correspondientes", expectedCount,
				Videoclub.getInstance().getHome(this.getEntityType()).searchByExample(example).size());
	}

	protected abstract Class<T> getEntityType();

}