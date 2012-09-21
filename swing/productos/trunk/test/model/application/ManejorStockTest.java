package model.application;

import static org.junit.Assert.*;
import junit.framework.Assert;

import model.domain.Item;

import org.junit.Test;

public class ManejorStockTest extends PersistentTest{

	private Stock stock;
	
	@Override
	public void setUp() {
		super.setUp();
		stock = new Stock();
	}
	
	@Test
	public void emptySearch() {
		stock.setNombre("muchaFruta");
		stock.buscar();
		assertTrue(stock.getResult().isEmpty());
	}
	
	protected void assertContains(String string) {
		for(Item item : stock.getResult()) {
			if(item.getProducto().getNombre().equals(string)) {
				return;
			}
		}
		Assert.fail("La busqueda no contiene al producto " + string);
	}
	@Test 
	public void busquedaPorNombreCompleto() {
		stock.setNombre("Manzana");
		stock.buscar();
		assertEquals(1, stock.getResult().size());
		assertContains("Manzana");		
	}
	
	@Test 
	public void busquedaPorNombreIncompleto() {
		stock.setNombre("an");
		stock.buscar();
		assertEquals(2, stock.getResult().size());
		assertContains("Manzana");
		assertContains("Naranja");

	}
	

	@Test 
	public void busquedaPorCantidad() {
		stock.setCantidad(4);
		stock.buscar();
		assertEquals(2, stock.getResult().size());
		assertContains("Naranja");
		assertContains("Papa");		
	}
	
	@Test 
	public void busquedaPorNombreCantidad() {
		stock.setCantidad(4);
		stock.setNombre("an");
		stock.buscar();
		assertEquals(1, stock.getResult().size());
		assertContains("Naranja");		
	}
	
	@Test 
	public void buscarSinFiltros() {
		stock.buscar();
		assertEquals(3, stock.getResult().size());
		assertContains("Naranja");
		assertContains("Manzana");
		assertContains("Papa");
	}
	
	//No estoy seguro sobre este test
	@Test 
	public void buscarFiltroVacio() {
		stock.setNombre("");
		stock.buscar();
		assertEquals(3, stock.getResult().size());
		assertContains("Naranja");
		assertContains("Manzana");
		assertContains("Papa");
	}
}
