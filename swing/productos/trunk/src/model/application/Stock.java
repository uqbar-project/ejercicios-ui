package model.application;

import java.util.ArrayList;
import java.util.List;

import model.domain.Item;
import model.domain.persistence.ItemHome;
import model.domain.persistence.Repository;

public class Stock {

	private List<Item> result = new ArrayList<Item>();
	private Item selected;
	private Integer cantidad;
	private String nombre;

	public Stock() {
	}

	public void setResult(List<Item> resultado) {
		this.result = resultado;
	}

	public List<Item> getResult() {
		return this.result;
	}

	public void setSelected(Item selected) {
		this.selected = selected;

		System.out
				.println("El seleccionado es "
						+ (selected != null ? selected.getProducto()
								.getNombre() : null));
	}

	public Item getSelected() {
		return this.selected;
	}

	public void buscar() {
		System.out.println("Buscando");
		ItemHome home = Repository.getInstance().get(Item.class);
		this.setResult(home.buscarPorNombreYCantidad(this.getNombre(),
				this.getCantidad()));
	}

	public void setNombre(String nombre) {
		System.out.println("Cambiando nombre: " + nombre);
		this.nombre = nombre;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public Integer getCantidad() {
		return this.cantidad;
	}

	public void limpiar() {
		this.setCantidad(null);
		this.setNombre(null);
		this.setSelected(null);
		this.result.clear();
	}

	public void setSelected(int selectedRow) {
		if (selectedRow < 0 || selectedRow >= this.getResult().size()) {
			this.setSelected(null);
		} else {
			this.setSelected(this.getResult().get(selectedRow));
		}
	}

	public int getSelectedIndex() {
		return this.result.indexOf(this.getSelected());
	}

}
