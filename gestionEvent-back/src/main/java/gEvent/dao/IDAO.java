package gEvent.dao;

import java.util.List;

public interface IDAO<T,K> {
	
	 String urlBdd = "jdbc:mysql://localhost:3306/gestion_event";
	 String loginBdd="root";
	 String passwordBdd ="";
	
	
	public T findById(K id);
	public List<T> findAll();
	
	//Pour l'instant, on return null sur insert et update, on le change à partir de JPA
	public T insert(T o);
	public T update(T o);
	
	public void delete(K id);

}
