package orchestre.model;

import org.springframework.stereotype.Component;

@Component
public class ClassMetier {
	
	public void demo() 
	{
		System.out.println("---Traitement de la méthode metier----");
	}
	
	
	
	public String demo2(boolean plante) throws RuntimeException 
	{
		System.out.println("---Traitement de la méthode metier 2----");
		
		if(plante==true) 
		{
			throw new RuntimeException("la methode plante !");
		}
		return "un String qu'on retourne !";
	}
}
