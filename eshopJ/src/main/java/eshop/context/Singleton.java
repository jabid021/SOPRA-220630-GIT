package eshop.context;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import eshop.dao.DAOProduit;
import eshop.dao.IDAOProduit;

public class Singleton {
	
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistenceJPA");
	private IDAOProduit daoProduit = new DAOProduit();
	

	private static Singleton instance;

	
	private Singleton() {}
	
	
	
	public static Singleton getInstance() {
		if(instance == null) 
		{
			instance=new Singleton();
		}
		
		return instance;
	}




	public IDAOProduit getDaoProduit() {
		return daoProduit;
	}



	public void setDaoProduit(IDAOProduit daoProduit) {
		this.daoProduit = daoProduit;
	}



	public EntityManagerFactory getEmf() {
		return emf;
	}



	public void setEmf(EntityManagerFactory emf) {
		this.emf = emf;
	}

	
	
	


	
	
	
	

}
