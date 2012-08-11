package uqbar.videoclub;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import tadp.blocbaster.daos.Videoclub;
import tadp.blocbaster.entidades.Socio;

/**
 * 
 * @author Sergio
 * @author jfernandes (refactor to reuse code)
 */
public class TestSocio extends TestModeloDeNegocio<Socio> {

	@Override
	protected Class<Socio> getEntityType() {
		return Socio.class;
	}

	@Test
	public void testGetClientes() {
		assertEquals("No trajo la cantidad de clientes esperados", Videoclub.getInstance().getHome(Socio.class)
				.allInstances().size(), 4);
	}

	@Test
	public void testGetClientesPorCriterio() {
		this.assertFindByExample(new Socio("Sergio", null), 1);
		this.assertFindByExample(new Socio("er", null), 3);
		this.assertFindByExample(new Socio("Monet", null), 0);
		this.assertFindByExample(new Socio(null, "55"), 2);
		assertEquals("No trajo al cliente esperado", this.unSocio, Videoclub.getInstance().getHome(Socio.class)
				.searchById(2));
	}

	@Test
	public void testBuscador() {
		this.assertFindByExample(new Socio("er", "Ur"), 2);
		this.assertFindByExample(new Socio("er", "ur"), 2);
		this.assertFindByExample(new Socio("A", null), 4);
		this.assertFindByExample(new Socio(null, "A"), 4);
	}

	@Test
	public void testActualizarClientes() {
		String viejaDireccion = "Urquiza 553";
		String nuevaDireccion = "San Urquiza 444";

		Socio cliente = this.buscarASergio();
		assertEquals("la direcciones inicial no es la esperada al inicio del test", cliente.getDireccion()
				.toLowerCase(), viejaDireccion.toLowerCase());

		cliente.setDireccion(nuevaDireccion);

		Videoclub.getInstance().getHome(Socio.class).update(cliente);
		cliente = this.buscarASergio();
		assertEquals("la direccion deberia ser la misma", cliente.getDireccion().toLowerCase(),
				nuevaDireccion.toLowerCase());
	}

	protected Socio buscarASergio() {
		return Videoclub.getInstance().getHome(Socio.class).searchByExample(new Socio("sergio", null)).get(0);
	}

	@Test
	public void testRegistrarNuevoCliente() {
		Socio socio = new Socio("Demian", "Medrano 951", null, null);
		Videoclub.getInstance().getHome(Socio.class).create(socio);
		Socio clienteABuscar = new Socio("Demian", null);
		assertEquals("no son el mismo cliente", socio,
				Videoclub.getInstance().getHome(Socio.class).searchByExample(clienteABuscar).get(0));
		Videoclub.getInstance().getHome(Socio.class).delete(socio);
	}

	@Test
	public void testEliminarCliente() {
		Socio cliente = new Socio("Demian", "Medrano 951", null, null);
		Videoclub.getInstance().getHome(Socio.class).create(cliente);
		Socio clienteABuscar = new Socio("Demian", null);
		assertEquals("no esta la cantidad de clientes correcta", 1, Videoclub.getInstance().getHome(Socio.class)
				.searchByExample(clienteABuscar).size());
		Videoclub.getInstance().getHome(Socio.class).delete(cliente);
		assertEquals("no debe quedar cliente", 0,
				Videoclub.getInstance().getHome(Socio.class).searchByExample(clienteABuscar).size());
	}

}