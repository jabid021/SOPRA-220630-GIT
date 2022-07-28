package gEvent.context;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

<<<<<<< HEAD
import gEvent.dao.DAOEvenement;
=======
import gEvent.dao.DAOIntervenant;
import gEvent.dao.DAOParticipation;
import gEvent.dao.DAOPrestation;
>>>>>>> groupe2
import gEvent.dao.IDAOCompte;
import gEvent.dao.IDAOEvenement;
import gEvent.dao.IDAOIntervenant;
import gEvent.dao.IDAOParticipation;
import gEvent.dao.IDAOPrestation;
import gEvent.dao.IDAOSpectateur;

public class Singleton {
	
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistenceJPA");
	
	//private IDAOCompte daoCompte = new DAOCompte();
	private IDAOEvenement daoEvenement= new DAOEvenement();
	//private IDAOIntervenant daoIntervenant = new DAOIntervenant();
	//private IDAOParticipation daoParticipation = new DAOParticipation();
	//private IDAOPrestation daoPrestation = new DAOPrestation();

	//private IDAOEvenement daoEvenement= new DAOEvenement();
	private IDAOIntervenant daoIntervenant = new DAOIntervenant();
	private IDAOParticipation daoParticipation = new DAOParticipation();
	private IDAOPrestation daoPrestation = new DAOPrestation();

	//private IDAOSpectateur daoSpectateur = new DAOSpectateur();
	

	
	
	
	
	private static Singleton instance;

	
	private Singleton() {}
	
	
	
	public static Singleton getInstance() {
		if(instance == null) 
		{
			instance=new Singleton();
		}
		
		return instance;
	}



	public IDAOCompte getDaoCompte() {
		return daoCompte;
	}



	public void setDaoCompte(IDAOCompte daoCompte) {
		this.daoCompte = daoCompte;
	}



	public IDAOEvenement getDaoEvenement() {
		return daoEvenement;
	}



	public void setDaoEvenement(IDAOEvenement daoEvenement) {
		this.daoEvenement = daoEvenement;
	}



	public IDAOIntervenant getDaoIntervenant() {
		return daoIntervenant;
	}



	public void setDaoIntervenant(IDAOIntervenant daoIntervenant) {
		this.daoIntervenant = daoIntervenant;
	}



	public IDAOParticipation getDaoParticipation() {
		return daoParticipation;
	}



	public void setDaoParticipation(IDAOParticipation daoParticipation) {
		this.daoParticipation = daoParticipation;
	}



	public IDAOPrestation getDaoPrestation() {
		return daoPrestation;
	}



	public void setDaoPrestation(IDAOPrestation daoPrestation) {
		this.daoPrestation = daoPrestation;
	}



	public IDAOSpectateur getDaoSpectateur() {
		return daoSpectateur;
	}



	public void setDaoSpectateur(IDAOSpectateur daoSpectateur) {
		this.daoSpectateur = daoSpectateur;
	}



	public EntityManagerFactory getEmf() {
		return emf;
	}



	public void setEmf(EntityManagerFactory emf) {
		this.emf = emf;
	}

	
	
	


	
	
	
	

}
