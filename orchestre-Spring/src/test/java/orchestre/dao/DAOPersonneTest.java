package orchestre.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import orchestre.config.AppConfig;
import orchestre.model.Personne;

@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration(classes={ AppConfig.class})

@Transactional
public class DAOPersonneTest {

	@Autowired
	IDAOPersonne daoPersonne;
	
	
	
	
	@Test
	public  void demoInsert() 
	{
		//Arrange
		Personne p = new Personne("Titi");
		Personne p2;
		//Act
		p=daoPersonne.save(p);
		p2 = daoPersonne.findById(p.getId()); 
		
		//Assert
		if(p2==null) 
		{
			fail();
		}
		else 
		{
			assertEquals("Titi", p2.getPrenom());
		}
		
	}
	
}
