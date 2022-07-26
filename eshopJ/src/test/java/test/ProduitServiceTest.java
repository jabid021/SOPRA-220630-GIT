package test;

import static org.junit.Assert.*;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import eshop.config.AppConfig;
import eshop.model.Produit;
import eshop.service.ProduitService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { AppConfig.class })
@Transactional
public class ProduitServiceTest {

	@Autowired
	private ProduitService produitService;

	@Test
//	@Commit
	public void test() {
		produitService.create(new Produit("produit1", 250.0, null));
	}

}
