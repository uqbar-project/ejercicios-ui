package model.domain.persistence;

import java.util.ArrayList;
import java.util.List;

import model.domain.Item;

public class ItemCollectionHome extends CollectionHome<Item> implements ItemHome {

	@Override
	public List<Item> buscarPorNombre(String string) {
		return filtrarPorNombre(string, this.cloneList());
	}


	@Override
	public List<Item> cantidadMenorIgualA(Integer cantidad) {
		return filtrarPorCantidad(cantidad, this.cloneList());
	}

	@Override
	public List<Item> buscarPorNombreYCantidad(String nombre, Integer cantidad) {
		return this.filtrarPorCantidad(cantidad, this.buscarPorNombre(nombre));
	}

	
	//TODO abstraer a un predicate para evitar duplicar el algoritmo
	private List<Item> filtrarPorNombre(String string, List<Item> source) {
		if(source == null || string == null) {
			return source; 
		}
		List<Item> list = new ArrayList<Item>();
		for(Item item : source) {
			if(item.getProducto().getNombre().contains(string)) {
				list.add(item);
			}
		}
		return list;
	}

	private List<Item> filtrarPorCantidad(Integer cantidad, List<Item> source) {
		if(cantidad == null) {
			return source; 
		}
		List<Item> list = new ArrayList<Item>();
		for(Item item : source) {
			if(item.getCantidad() <= cantidad) {
				list.add(item);
			}
		}
		return list;
	}





}


