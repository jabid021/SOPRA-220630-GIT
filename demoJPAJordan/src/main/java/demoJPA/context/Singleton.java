package demoJPA.context;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Singleton {
	
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistenceJPA");
	private static Singleton instance;

	
	private Singleton() {}
	
	
	
	public static Singleton getInstance() {
		if(instance == null) 
		{
			instance=new Singleton();
		}
		
		return instance;
	}



	public EntityManagerFactory getEmf() {
		return emf;
	}



	public void setEmf(EntityManagerFactory emf) {
		this.emf = emf;
	}

	
	
	


	
	
	
	

}
