package orchestre.test;

import org.springframework.beans.factory.annotation.Autowired;

import orchestre.model.ClassMetier;
import orchestre.model.Guitariste;
import orchestre.model.Pianiste;

public class Test {

	/*@Autowired
	Guitariste guitariste;
	
	@Autowired
	Pianiste pianiste;*/
	
	@Autowired
	ClassMetier c;
 
	public void run(String[] args) {

	//	Guitariste g = (Guitariste) ctx.getBean("guitariste");
	//	Pianiste p = (Pianiste) ctx.getBean("pianiste");
		
		
		//guitariste.jouer(); 
		//pianiste.jouer();
	
		
		System.out.println(c);
		
	}

}
