package test;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import demoJPA.context.Singleton;
import demoJPA.model.Adresse;
import demoJPA.model.Formateur;
import demoJPA.model.Matiere;
import demoJPA.model.Module;
import demoJPA.model.Ordinateur;
import demoJPA.model.Outil;
import demoJPA.model.Stagiaire;

public class Test {

	static EntityManagerFactory emf = Singleton.getInstance().getEmf();
	
	public static void init() 
	{
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
		//Avec de l'auto-increment, il ne faut jamais affecter un id � la main ! sinon c'est un update 
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

	public static void demoCascade() 
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistenceJPA");

		EntityManager em = emf.createEntityManager();

		/*
		Formateur f = em.find(Formateur.class, 2);
		System.out.println(f);
		//Suppression en cascade d'un formateur (on remove les modules puis on peut remove le formateur
		em.getTransaction().begin();

			for(Module m : f.getFormations()) 
			{
				em.remove(m);
			}
			em.remove(f);

		em.getTransaction().commit();

		em.close();*/
		emf.close();
	}
	
	
	
	
	public static void insert(Matiere m) 
	{
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		em.persist(m);
		em.getTransaction().commit();
		em.close();
		
	}
	
	public static Matiere update(Matiere m) 
	{
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		Matiere copie = em.merge(m);
		em.getTransaction().commit();
		em.close();
		return copie;
	}
	
	
	public static Matiere findById(Integer id) {
		EntityManager em = emf.createEntityManager();
		Matiere m = em.find(Matiere.class, id);
		em.close();
		return m;
	}
	
	

	public static void delete(Integer id) 
	{
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		Matiere m = em.find(Matiere.class, id);
		em.remove(m);
		em.getTransaction().commit();
		em.close();
		
	}
	
	
	public static void delete(Matiere m) 
	{
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		m=em.merge(m);
		em.remove(m);
		em.getTransaction().commit();
		em.close();
		
	}
	
	public static List<Matiere> findAll()
	{
		EntityManager em = emf.createEntityManager();
		List<Matiere> matieres = em.createQuery("from Matiere").getResultList();
		em.close();
		return matieres;
	}
	
	
	public static void main(String[] args) {
		//init();
		

		
	
		
		/*Matiere m = new Matiere("libelle",7777,3);
		System.out.println(m);
		
		insert(m);
		System.out.println(m);*/
		
		/*Matiere m = findById(5);
		System.out.println(m);
		delete(5);
		m = findById(5);
		System.out.println(m);*/
		
		
		/*for(Matiere m : findAll()) 
		{
			System.out.println(m);
		}*/
		
		
		//Matiere m = findById(6);
		Matiere m = new Matiere("SQL + Merise",3455,4);
	
	

		
		
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
			em.merge(m);
		em.getTransaction().commit();
	
		
		
		em.getTransaction().begin();
		em.remove(m);
		em.getTransaction().commit();
		em.close();
		
		
		
		emf.close();

		
		//em.remove(x) => x doit etre managed par JPA
		
		
		
		
		//em.find() = > return objet managed
		//em.remove() => //
		//findAll() => return une liste d'objet managed
		//em.persist(x) => x est managed
		//copieX = em.merge(x)=> x n'est pas managed, copieX est managed



	}

}
