package model.domain.persistence;

import java.util.ArrayList;
import java.util.List;

import model.domain.Persistible;

public class CollectionHome<T extends Persistible> implements Home<T>{

	int id = 1;
	private List<T> list = new ArrayList<T>();
	
	@Override
	public T findById(int id) {
		for(T t : this.getList()) {
			if(t.getId() == id) {
				return t;
			}
		}
		return null;
	}

	@Override
	public void insert(T t) {
		t.setId(createId());
		this.getList().add(t);
	}

	private int createId() {
		return id++;
	}

	@Override
	public void update(T t) {
		
	}

	@Override
	public void delete(T t) {
		this.getList().remove(t);
	}

	protected List<T> getList() {
		return list;
	}
	
	protected List<T> cloneList() {
		return new ArrayList<T>(this.getList());
	}

}
