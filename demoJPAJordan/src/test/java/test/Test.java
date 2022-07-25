package test;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import demoJPA.model.Adresse;
import demoJPA.model.Civilite;
import demoJPA.model.Personne;

public class Test {

	public static void main(String[] args) {
		
		Adresse a1 = new Adresse("6","rue rougemont","75009","Paris");
		Personne p1 = new Personne("jabid","toto123" ,"Abid", "Jordan", 173, LocalDate.parse("1993-05-01"), 2000.75, true, Civilite.Homme, a1);
		
	
	//	System.out.println(p1);
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistenceJPA");
		
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		em.persist(p1);
		
		em.getTransaction().commit();
		
		
		//Personne p= em.find(Personne.class, 1);
		//System.out.println(p);
		
		
		em.close();
		
		emf.close();
		
		
	}

}
