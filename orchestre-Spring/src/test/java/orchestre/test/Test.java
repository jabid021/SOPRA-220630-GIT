package orchestre.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import orchestre.model.Guitariste;
import orchestre.model.Pianiste;

public class Test {

	public static void main(String[] args) {

		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:application-context.xml");

		Guitariste g = (Guitariste) ctx.getBean("guitariste");
		Pianiste p = (Pianiste) ctx.getBean("pianiste");
		
		

		g.jouer();
		p.jouer();
	}

}
