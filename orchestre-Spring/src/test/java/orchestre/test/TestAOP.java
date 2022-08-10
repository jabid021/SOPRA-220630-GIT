package orchestre.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import orchestre.model.ClassMetier;

public class TestAOP {

	
	
	
	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:application-context.xml");

		//ClassMetier c = (ClassMetier) ctx.getBean("classMetier");
		//Recup un guitariste g ctx.getBean
		
		//c.demo();
		
		//c.demo2(false);
		
		System.out.println(g);
		
		System.out.println("Fin d'app");
		ctx.close();
	}

}
