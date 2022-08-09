package orchestre.model;

public class ClassMetier {
	
	public void demo() 
	{
		System.out.println("---Traitement de la méthode metier----");
	}
	
	
	
	public String demo2(boolean plante) throws Exception 
	{
		System.out.println("---Traitement de la méthode metier 2----");
		
		if(plante==true) 
		{
			throw new Exception("la methode plante !");
		}
		return "un String qu'on retourne !";
	}
}
