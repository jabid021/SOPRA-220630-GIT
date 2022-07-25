package test;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import demoJPA.model.Adresse;
import demoJPA.model.Formateur;
import demoJPA.model.Personne;
import demoJPA.model.Stagiaire;

public class Test {

	public static void main(String[] args) {
		
		Adresse a1 = new Adresse("6","rue rougemont","75009","Paris");
		Personne p1 = new Formateur("jabid","toto123" ,"Abid", "Jordan", 173, LocalDate.parse("1993-05-01"), 2000.758, true, null, a1,"JPA");
		
		Personne p2 = new Stagiaire("jd","password" ,"Doe", "John", 170, LocalDate.parse("1965-05-01"), 2000.758, false, null, a1,153,"Asus");
		
		
		//Avec de l'auto-increment, il ne faut jamais affecter un id à la main ! sinon c'est un update 
		//p1.setId(78);
	//	System.out.println(p1);
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistenceJPA");
		
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		em.persist(p1);
		em.persist(p2);
		
		em.getTransaction().commit();
		
		
		
		
		em.close();
		

		em = emf.createEntityManager();
		
		Personne p= em.find(Personne.class, 1);
		System.out.println(p);
		
		
		emf.close();
		
		
	}

}
