package orchestre.test;

import org.springframework.beans.factory.annotation.Autowired;

import orchestre.model.ClassMetier;
import orchestre.model.IMusicien;
import orchestre.model.Pianiste;

public class Test {

	@Autowired
	IMusicien guitariste;
	
	@Autowired
	Pianiste pianiste;
	
	@Autowired
	ClassMetier c;
 
	public void run(String[] args) {

	//	Guitariste g = (Guitariste) ctx.getBean("guitariste");
	//	Pianiste p = (Pianiste) ctx.getBean("pianiste");
		
		
		guitariste.jouer(); 
		//pianiste.jouer();
	
		//guitariste.toString();
		//c.demo();

		
		//c.demo2(true);
		//c.demo2(false);
		
	}

}
