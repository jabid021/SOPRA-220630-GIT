package eshop.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Optional;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import eshop.config.AppConfig;
import eshop.model.Fournisseur;
import eshop.model.Produit;

@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration(classes={ AppConfig.class})

@Transactional
public class DAOProduitTest {


	@Autowired
	IDAOProduit daoProduit;

	@Autowired
	IDAOPersonne daoPersonne;

	@Test
	public void initDAO() 
	{
		assertNotNull(daoProduit);
	}


	@Test
	public void addTest() 
	{

		//Arrange
		Fournisseur f = new Fournisseur("nom", "prenom", "societe");
		daoPersonne.save(f);
		Produit p = new Produit("lib", 1, f);
		Produit p2;
		//Act
		p=daoProduit.save(p);
		p2 = daoProduit.findById(p.getId()).get();
		//Assert
		if(p2==null) {fail();}
		else 
		{
			assertEquals("lib", p2.getLibelle());
			assertTrue(1==p2.getPrix());
			assertEquals(f.getId(), p2.getFournisseur().getId());

		}

	}

	@Test
	public void findTest() 
	{
		//Arrange
		Fournisseur f = new Fournisseur("nom", "prenom", "societe");
		daoPersonne.save(f);
		Produit p = new Produit("lib", 1, f);
		daoProduit.save(p);
		Produit p2;
		//Act
		p2 = daoProduit.findById(p.getId()).get();
		//Assert
		if(p2==null) {fail();}

	}

	@Test
	public void deleteTest() 
	{
		//Arrange
		Fournisseur f = new Fournisseur("nom", "prenom", "societe");
		daoPersonne.save(f);
		Produit p = new Produit("lib", 1, f);
		daoProduit.save(p);
		Produit p2;
		//Act

		daoProduit.deleteById(p.getId());
		
	
		//Assert
		if(daoProduit.findById(p.getId()).isPresent()) {fail();}


	}
}
