package test;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import demoJPA.model.Adresse;
import demoJPA.model.Formateur;
import demoJPA.model.Matiere;
import demoJPA.model.Ordinateur;
import demoJPA.model.Outil;
import demoJPA.model.Personne;
import demoJPA.model.Stagiaire;
import demoJPA.model.Module;

public class Test {

	public static void main(String[] args) {
		
		
		Ordinateur o1 = new Ordinateur("Asus", "Windows");
		
		Matiere m1 = new Matiere("Algo avec Java",3458,3);
		Matiere m2 = new Matiere("SQL",3455,3);
		Matiere m3= new Matiere("Java Objet",3817,2);
		Matiere m4 = new Matiere("JPA",8547,4);
		
		Outil outil1 = new Outil("Eclipse");
		Outil outil2 = new Outil("Wamp");
		Outil outil3 = new Outil("Mamp");
		Outil outil4 = new Outil("Xamp");
		
		
		m1.getOutils().add(outil1);
		
		m2.getOutils().add(outil2);
		m2.getOutils().add(outil3);
		m2.getOutils().add(outil4);
		
		m3.getOutils().add(outil1);
		
		m4.getOutils().add(outil1);
		
		
		Adresse a1 = new Adresse("6","rue rougemont","75009","Paris");
		Formateur p1 = new Formateur("jabid","toto123" ,"Abid", "Jordan", 173, LocalDate.parse("1993-05-01"), 2000.758, true, null, a1);
		
		Stagiaire p2 = new Stagiaire("jd","password" ,"Doe", "John", 170, LocalDate.parse("1965-05-01"), 2000.758, false, null, a1);
		
		Module mod1 = new Module(p1,m1);
		Module mod2 = new Module(p1,m2);
		Module mod3= new Module(p1,m3);
		Module mod4 = new Module(p1,m4);
		
		
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
		
		em.persist(outil1);
		em.persist(outil2);
		em.persist(outil3);
		em.persist(outil4);
		
		em.persist(o1);
		em.persist(m1);
		em.persist(m2);
		em.persist(m3);
		em.persist(m4);
		
		
		
		
		em.persist(p1);
		em.persist(p2);
		
		
		em.persist(mod1);
		em.persist(mod2);
		em.persist(mod3);
		em.persist(mod4);
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
