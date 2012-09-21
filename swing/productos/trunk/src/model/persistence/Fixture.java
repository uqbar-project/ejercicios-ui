package model.persistence;

import model.domain.Item;
import model.domain.Producto;
import model.domain.persistence.CollectionHome;
import model.domain.persistence.Home;
import model.domain.persistence.ItemCollectionHome;
import model.domain.persistence.ItemHome;
import model.domain.persistence.Repository;


public class Fixture {

	
	public void execute(){
		addHomes();		
		this.addObjects();
	}
	
	protected void addObjects() {
		this.add(5, "Manzana", 1, 3);
		this.add(3, "Naranja", 2, 4);
		this.add(4, "Papa", 1, 3);

	}

	protected void add(int cantidad, String nombre, float costo, float precio) {
		Producto producto = createProducto(nombre, costo, precio);
		createItem(cantidad, producto);
	}

	protected void createItem(int cantidad, Producto producto) {
		Item item = new Item();
		item.setProducto(producto);
		item.setCantidad(cantidad);
		ItemHome itemHome = Repository.getInstance().get(Item.class);
		itemHome.insert(item);
	}

	protected Producto createProducto(String nombre, float costo, float precio) {
		Producto producto = new Producto();
		producto.setCosto(costo);
		producto.setPrecio(precio);
		producto.setNombre(nombre);
		Repository.getInstance().get(Producto.class).insert(producto);
		return producto;
	}

	private void addHomes() {
		Repository.getInstance().put(Producto.class, new CollectionHome<Producto>());
		Repository.getInstance().put(Item.class, new ItemCollectionHome());
	}
}
