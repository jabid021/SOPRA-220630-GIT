package test;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import demoJPA.model.Adresse;
import demoJPA.model.Formateur;
import demoJPA.model.Matiere;
import demoJPA.model.Ordinateur;
import demoJPA.model.Personne;
import demoJPA.model.Stagiaire;

public class Test {

	public static void main(String[] args) {
		
		
		Ordinateur o1 = new Ordinateur("Asus", "Windows");
		
		Matiere m1 = new Matiere("Algo avec Java",3458,3);
		Matiere m2 = new Matiere("SQL",3455,3);
		Matiere m3= new Matiere("Java Objet",3817,2);
		Matiere m4 = new Matiere("JPA",8547,4);
		
		
		
		Adresse a1 = new Adresse("6","rue rougemont","75009","Paris");
		Formateur p1 = new Formateur("jabid","toto123" ,"Abid", "Jordan", 173, LocalDate.parse("1993-05-01"), 2000.758, true, null, a1);
		
		Stagiaire p2 = new Stagiaire("jd","password" ,"Doe", "John", 170, LocalDate.parse("1965-05-01"), 2000.758, false, null, a1);
		
		p1.getMatieres().add(m1);
		p1.getMatieres().add(m2);
		p1.getMatieres().add(m3);
		p1.getMatieres().add(m4);
		
		
		p2.setOrdinateur(o1);
		p2.setMatiere(m4);
		//Avec de l'auto-increment, il ne faut jamais affecter un id à la main ! sinon c'est un update 
		//p1.setId(78);
	//	System.out.println(p1);
		
		
		
		/*Lion simba = new Lion("orange");
		
		Chien chien= new Chien("blanc","bichon");
		
		Dauphin d = new Dauphin("gris",150);
		
		
		Bateau b = new Bateau();
		Avion a = new Avion(2,"pilote");
		Voiture v = new Voiture(4,"Smart");
		
		Bateau b2 = new Bateau();
		Bateau b3 = new Bateau();*/
		
		
		
		
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistenceJPA");
		
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		em.persist(p1);
		em.persist(p2);
		em.persist(o1);
		em.persist(m1);
		em.persist(m2);
		em.persist(m3);
		em.persist(m4);
		/*em.persist(simba);
		em.persist(d);
		em.persist(chien);
		em.persist(b);
		em.persist(a);
		em.persist(v);
		em.persist(b2);
		em.persist(b3);*/
		em.getTransaction().commit();
		
		
		
		
		em.close();
		

		em = emf.createEntityManager();
		
		/*List<Personne> zoom = em.createQuery("Select p from Personne p").getResultList();
		for(Personne p : zoom) 
		{
			System.out.println(p);
		}*/
		
		
		/*List<Animal> zoo = em.createQuery("Select a from Animal a").getResultList();
		for(Animal an : zoo) 
		{
			System.out.println(an);
		}*/
		/*
		List<Vehicule> vehi = em.createQuery("Select v from Voiture v").getResultList();
		for(Vehicule ve : vehi) 
		{
			System.out.println(ve);
		}*/
		
		emf.close();
		
		
	}

}
