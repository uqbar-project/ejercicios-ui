package model.domain.persistence;

import java.util.HashMap;
import java.util.Map;

/**
 * Es el encargo de mantener las referencias a las Homes
 * 
 * @author leo
 * 
 */
@SuppressWarnings({ "unchecked", "rawtypes" })
public class ApplicationContext {

	private static ApplicationContext instance = new ApplicationContext();

	Map map = new HashMap();

	public synchronized static ApplicationContext getInstance() {
		if (instance == null) {
			instance = new ApplicationContext();
		}
		return instance;
	}

	public Object get(Object key) {
		return this.map.get(key);
	}

	public void put(Class key, Object value) {
		this.map.put(key, value);
	}

	public void clear() {
		this.map = new HashMap();
	}

}
