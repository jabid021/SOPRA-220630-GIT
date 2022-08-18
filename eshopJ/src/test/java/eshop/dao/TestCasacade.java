package eshop.dao;

import java.util.Optional;

import javax.persistence.NoResultException;
import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import eshop.config.AppConfig;
import eshop.exception.ProduitException;
import eshop.model.Achat;
import eshop.model.Client;
import eshop.model.Produit;
import eshop.service.ProduitService;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { AppConfig.class })
@Transactional
public class TestCasacade {

	@Autowired
	private IDAOProduit produitRepo;

	@Autowired
	private IDAOAchat achatRepo;

	@Autowired
	private IDAOPersonne personRepo;

	@Autowired
	private ProduitService produitService;

	@Test(expected = ProduitException.class)
	public void validation() {
		produitService.create(new Produit("jjj",0,null));
	}

//	@Test
//	@Commit
	public void init() {
		Produit p = new Produit("tele", 200.00, null);
		produitRepo.save(p);

		Client c = new Client("aaa", "aaa", 20, null);
		personRepo.save(c);

		Achat achat = new Achat(c, p);

		achatRepo.save(achat);
	}

//	@Test
//	@Commit
	public void testDelete() {
		Produit p = produitRepo.findById(8).orElseThrow(NoResultException::new);
//		Optional<Produit> opt = produitRepo.findById(1);
//		if (opt.isPresent()) {
//			p = opt.get();
//		} else {
//			throw new NoResultException();
//		}
		assertNotNull(p);
//		achatRepo.setNullToProduitByProduit(p);
		achatRepo.deleteByProduit(p);
		produitRepo.delete(p);
	}

	// @Test
	public void EqualsTest() {
		Produit p = new Produit("tele", 200.00, null);
		System.out.println(p.hashCode() + "\n" + p);
		Produit p2 = new Produit(null, 200.00, null);
		System.out.println(p2.hashCode() + "\n" + p2);
		assertEquals(p, p2);

	}
}
