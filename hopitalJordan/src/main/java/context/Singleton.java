package context;

import java.util.LinkedList;

import dao.IDAOCompte;
import dao.IDAOPatient;
import dao.IDAOVisite;
import dao.jdbc.DAOPatientJDBC;
import dao.jdbc.DAOVisiteJDBC;
import dao.jpa.DAOCompte;
import model.Patient;

public class Singleton {
	
	private LinkedList<Patient> fileAttente = new LinkedList();
	private IDAOCompte daoC = new DAOCompte();
	private IDAOPatient daoP = new DAOPatientJDBC();
	private IDAOVisite daoV = new DAOVisiteJDBC();
	
	
	private static Singleton instance;

	
	private Singleton() {}
	
	
	
	public static Singleton getInstance() {
		if(instance == null) 
		{
			instance=new Singleton();
		}
		
		return instance;
	}

	
	
	

	public LinkedList<Patient> getFileAttente() {
		return fileAttente;
	}


	public void setFileAttente(LinkedList<Patient> fileAttente) {
		this.fileAttente = fileAttente;
	}


	public IDAOCompte getDaoC() {
		return daoC;
	}


	public void setDaoC(IDAOCompte daoC) {
		this.daoC = daoC;
	}


	public IDAOPatient getDaoP() {
		return daoP;
	}


	public void setDaoP(IDAOPatient daoP) {
		this.daoP = daoP;
	}


	public IDAOVisite getDaoV() {
		return daoV;
	}


	public void setDaoV(IDAOVisite daoV) {
		this.daoV = daoV;
	}




	
	
	
	

}
