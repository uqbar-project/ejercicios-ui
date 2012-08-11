package uqbar.videoclub;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import tadp.blocbaster.entidades.Pedido;
import tadp.blocbaster.entidades.Pelicula;

/**
 * @author Sergio
 */
public class TestAlquilarPeliculas extends TestModeloDeNegocio<Pelicula> {
	private Pedido pedido;

	@Override
	protected Class<Pelicula> getEntityType() {
		return Pelicula.class;
	}

	@Before
	public void init() {
		this.pedido = new Pedido();
		this.pedido.addPelicula(this.unaPeliculaDeAccion);
		this.pedido.addPelicula(this.unaPeliculaDeMiedo);
		this.pedido.addPelicula(this.unaPeliculaDeAccion);
		this.pedido.addPelicula(this.unaPeliculaDeMiedo);
		this.pedido.setMedioDePago(this.unMedioDePago);
	}

	@Test
	public void testAlquilarPeliculas() {
		assertEquals("no deberia tener ningun pedido", 0, this.unSocio.getPedidos().size());
		this.unSocio.addPedido(this.pedido);
		assertEquals("deberia tener mas pedidos", 1, this.unSocio.getPedidos().size());
	}

	@Test
	public void calcularCostoEnvio() {
		assertEquals("no dio correctamente", this.pedido.getCosto(), 44.0, 0.1);
	}

}