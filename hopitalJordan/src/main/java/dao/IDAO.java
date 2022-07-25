package dao;

import java.util.List;

import model.Compte;

public interface IDAO<T,K> {
	
	public T findById(K id);
	public List<T> findAll();
	public void insert(T o);
	public void update(T o);
	public void delete(T o);

	
	
}
