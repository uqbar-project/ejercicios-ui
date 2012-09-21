package model.domain;

public class Item extends Persistible {
	private Producto producto;
	private int cantidad;
	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	public Producto getProducto() {
		return producto;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public int getCantidad() {
		return cantidad;
	}
	
}
