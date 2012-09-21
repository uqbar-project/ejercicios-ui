package model.domain.persistence;

public interface Home<T> {

	T findById(int code);
	void insert(T t);
	void update(T t);
	void delete(T t);
	
}
