package orchestre.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;

public class SuperMathsTest {



	@BeforeClass
	public static void debutTest() 
	{
		System.out.println("Debut des test");
	}


	@Test
	public void initSuperMaths() 
	{

		//Arrange
		SuperMaths s;

		//Act
		s = new SuperMaths();

		//Assert
		assertNotNull(s);

	}

	@Test
	public void testAdd() 
	{
		//Arrange
		SuperMaths s=new SuperMaths();
		int a=1;
		int b=5;

		//Act

		int result = s.additionner(a, b);

		//Assert
		assertTrue((6==result));
		assertEquals(6, result);
	}
	
	@Test
	public void testSoustraction() 
	{
		//Arrange
		SuperMaths s=new SuperMaths();
		int a=6;
		int b=5;

		//Act
		int result = s.soustraire(a, b);

		//Assert
		assertTrue((0!=result));
		assertNotEquals(0, result);
	}
	
	
	@Test
	public void testSoustraction2() 
	{
		//Arrange
		SuperMaths s=new SuperMaths();
		assertTrue((0!=s.soustraire(6, 5)));
		assertNotEquals(0, s.soustraire(6, 5));
	}
	

}
