package model.domain.persistence;

import java.util.List;

import model.domain.Item;

public interface ItemHome extends Home<Item> {
	List<Item> buscarPorNombre(String string);
	List<Item> cantidadMenorIgualA(Integer cantidad);
	List<Item> buscarPorNombreYCantidad(String nombre, Integer cantidad);
	
}
