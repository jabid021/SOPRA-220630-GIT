package test;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import eshop.model.Adresse;
import eshop.model.Client;
import eshop.model.Fournisseur;
import eshop.model.Produit;

public class Test {

	public static void main(String[] args) {
		
		Adresse a = new Adresse("6","Rue Rougemont","75009","Paris");
		Client c = new Client("Doe","Jonh",42,LocalDate.parse("1980-11-02"));
		Fournisseur f = new Fournisseur("Abid","Jordan","AJC");
		Produit p = new Produit("Formation Java",1800.75);
		
		f.setAdresse(a);
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistenceJPA");

		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();
		
		
		em.persist(c);
		em.persist(f);
		em.persist(p);
		
		em.getTransaction().commit();
		
		em.close();
		emf.close();
	}

}
