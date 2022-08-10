package orchestre.test;

import org.springframework.beans.factory.annotation.Autowired;

import orchestre.dao.IDAOPersonne;
import orchestre.model.ClassMetier;
import orchestre.model.IMusicien;
import orchestre.model.Personne;
import orchestre.model.Pianiste;

public class Test {

	@Autowired
	IMusicien guitariste;
	
	@Autowired
	Pianiste pianiste;
	
	@Autowired
	ClassMetier c;
	
	@Autowired
	IDAOPersonne daoPersonne;
 
	public void run(String[] args) {

		//Personne p = new Personne("Jordan");
		
		//daoPersonne.save(p);
		
		Personne p = daoPersonne.seConnecter("Jordan");
		System.out.println(p);
		
		
	//	Guitariste g = (Guitariste) ctx.getBean("guitariste");
	//	Pianiste p = (Pianiste) ctx.getBean("pianiste");
		
		
	//	guitariste.jouer(); 
		//pianiste.jouer();
	
		//guitariste.toString();
		//c.demo();

		
		//c.demo2(true);
		//c.demo2(false);
		
	}

}
