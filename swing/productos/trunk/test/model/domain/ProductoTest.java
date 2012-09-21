package model.domain;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ProductoTest {

	@Test
	public void ganancia() {
		Producto producto = new Producto();
		producto.setPrecio(10);
		producto.setCosto(4);
		assertEquals(6, producto.ganancia(), 0.01);
	}
}
