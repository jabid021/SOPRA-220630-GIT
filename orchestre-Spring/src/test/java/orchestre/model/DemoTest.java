package orchestre.model;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class DemoTest {

	@BeforeClass
	public static void testBefore() 
	{
		
	System.out.println("BeforeClass");
		
	}
	
	@Before
	public void beforeAll() 
	{
		System.out.println("BeforeTest");
		//Arrange
		
		
		//Act
		
		///Assert
	}
	
	@Test
	public void TestPrenom() 
	{	
		//Arrange
		String prenom;
		
		
		//Act
		prenom="Jordan";
		
		//Assert
		
		assertEquals("Jord",prenom);
		
	}
	
	
	@Test
	public void testY() 
	{
		
		//Arrange
		
		
		//Act
		
		///Assert
	}
}
