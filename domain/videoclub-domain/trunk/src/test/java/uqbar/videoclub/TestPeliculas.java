package uqbar.videoclub;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import tadp.blocbaster.daos.Videoclub;
import tadp.blocbaster.entidades.Pelicula;

/**
 * 
 * @author Sergio
 * @author jfernandes (refactor to reuse code)
 */
public class TestPeliculas extends TestModeloDeNegocio<Pelicula> {

	@Override
	protected Class<Pelicula> getEntityType() {
		return Pelicula.class;
	}

	/**
	 * Test de peliculas
	 */
	@Test
	public void testGetPeliculas() {
		assertEquals("No trajo la cantidad de peliculas esperadas", 14, Videoclub.getInstance().getHome(Pelicula.class)
				.allInstances().size());
	}

	@Test
	public void testBuscador() {
		this.assertFindByExample(new Pelicula("a", "a"), 9);
		this.assertFindByExample(new Pelicula("A", "A"), 9);
		this.assertFindByExample(new Pelicula(null, null, "ePIca"), 4);
		this.assertFindByExample(new Pelicula("señor", "p", "ePIca"), 3);
		assertEquals("no encontro la peli por id", Videoclub.getInstance().getHome(Pelicula.class).searchById(1),
				this.unaPeliculaDeAccion);
	}

	@Test
	public void testGetPeliculasPorCriterio() {
		this.assertFindByExample(new Pelicula("señor", null), 3);
		this.assertFindByExample(new Pelicula(null, "Peter Jackson"), 3);
		this.assertFindByExample(new Pelicula("señor", "Peter Jackson"), 3);
	}

	@Test
	public void testGeneros() {
		assertEquals("no se encontró los generos debidos", 5, Videoclub.getInstance().getGeneros().size());
	}

	@Test
	// REFACTORME
	public void testActualizarPelicula() {
		String directorViejo = "Espilber";
		String directorNuevo = "Spielberg";

		Pelicula pelicula = Videoclub.getInstance().getHome(Pelicula.class)
				.searchByExample(new Pelicula("Soy Leyenda", null)).get(0);
		assertEquals("la direcciones inicial es incorrecta", pelicula.getDirector(), directorViejo);

		pelicula.setDirector(directorNuevo);

		Videoclub.getInstance().getHome(Pelicula.class).update(pelicula);

		pelicula = Videoclub.getInstance().getHome(Pelicula.class).searchByExample(new Pelicula("Soy Leyenda", null))
				.get(0);
		assertEquals("No se actualizo el director de la pelicula", directorNuevo, pelicula.getDirector());

	}

}