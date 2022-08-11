package test;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import eshop.dao.IDAOAchat;
import eshop.dao.IDAOPersonne;
import eshop.dao.IDAOProduit;
import eshop.model.Client;
import eshop.model.Personne;
import eshop.model.Produit;

public class Test {

	@Autowired
	IDAOPersonne daoPersonne;
 
	@Autowired
	IDAOAchat daoAchat;
 
	@Autowired
	IDAOProduit daoProduit;
 
	public void run(String[] args) {

		
		/*List<Produit> produits = daoProduit.findAll();
		
		for(Produit p : produits) {System.out.println(p);}
		
		Personne c = new Client("test","test",20,LocalDate.parse("2000-01-01"));
		
		c=daoPersonne.save(c);
		
		System.out.println(c);*/
		
		System.out.println(daoProduit.findByLibelleRessemble("a"));
	}

}
