package model.persistence;

import model.domain.Item;
import model.domain.Producto;
import model.domain.persistence.ApplicationContext;
import model.domain.persistence.ItemCollectionHome;
import model.domain.persistence.ItemHome;
import model.domain.persistence.ProductoCollectionHome;
import model.domain.persistence.ProductoHome;

public class Fixture {

	public void execute() {
		this.addHomes();
		this.addObjects();
	}

	protected void addObjects() {
		this.add(5, "Manzana", 1, 3);
		this.add(3, "Naranja", 2, 4);
		this.add(4, "Papa", 1, 3);

	}

	protected void add(int cantidad, String nombre, float costo, float precio) {
		Producto producto = this.createProducto(nombre, costo, precio);
		this.createItem(cantidad, producto);
	}

	protected void createItem(int cantidad, Producto producto) {
		Item item = new Item();
		item.setProducto(producto);
		item.setCantidad(cantidad);
		ItemHome itemHome = (ItemHome) ApplicationContext.getInstance().get(
				Item.class);
		itemHome.insert(item);
	}

	protected Producto createProducto(String nombre, float costo, float precio) {
		Producto producto = new Producto();
		producto.setCosto(costo);
		producto.setPrecio(precio);
		producto.setNombre(nombre);
		ProductoHome productoHome = (ProductoHome) ApplicationContext
				.getInstance().get(Producto.class);
		productoHome.insert(producto);
		return producto;
	}

	private void addHomes() {
		ApplicationContext.getInstance().put(Producto.class,
				new ProductoCollectionHome());
		ApplicationContext.getInstance().put(Item.class,
				new ItemCollectionHome());
	}
}
