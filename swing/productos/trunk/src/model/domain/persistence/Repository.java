package model.domain.persistence;

import java.util.HashMap;
import java.util.Map;

import model.domain.Item;
import model.domain.Producto;

public class Repository {

	private static Repository instance = new Repository();
	
	Map<Class<?>, Home<?>> map = new HashMap<Class<?>, Home<?>>();

	public <T, H extends Home<T>> H get(Class<T> key) {
		return (H) map.get(key);
	}

	public <T> void put(Class<T> key, Home<T> value) {
		map.put(key, value);
	}

	public synchronized static Repository getInstance() {
		if(instance == null) {
			instance = new Repository();
		}
		return instance;
	}
	
	public static void initForCollection() {
		getInstance().put(Item.class, new ItemCollectionHome());
		getInstance().put(Producto.class, new CollectionHome<Producto>());
	}

	public void clear() {
		this.map = new HashMap<Class<?>, Home<?>>();
	}
	
	


}
