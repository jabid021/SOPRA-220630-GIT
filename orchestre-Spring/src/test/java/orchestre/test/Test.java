package orchestre.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import orchestre.config.AppConfig;
import orchestre.model.Guitariste;
import orchestre.model.Pianiste;

public class Test {

	public static void main(String[] args) {

	//	ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:application-context.xml");
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
	//	Guitariste g = (Guitariste) ctx.getBean("guitariste");
	//	Pianiste p = (Pianiste) ctx.getBean("pianiste");
		
		

		guitariste.jouer(); 
		pianiste.jouer();
	}

}
