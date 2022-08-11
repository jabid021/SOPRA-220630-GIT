package orchestre.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;

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

		Personne p = new Personne("John","login","password");
		
		//daoPersonne.save(p);
		
		//Personne p = daoPersonne.seConnecter("Jordan");*
		//daoPersonne.save(p);
		/*System.out.println(p.getId());
		
		System.out.println(daoPersonne.seConnecter("Toto"));
		
		;*/
		System.out.println(daoPersonne.findByPrenom("Toto",PageRequest.of(0,15)));
		
		System.out.println(daoPersonne.findByLoginAndPassword("login", "password"));
		
		
		daoPersonne.deleteById(null);
		
		//System.out.println(daoPersonne.find);
		
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
