package orchestre.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import orchestre.model.ClassMetier;

public class TestAOP {

	
	
	
	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:application-context.xml");

		ClassMetier c = (ClassMetier) ctx.getBean("classMetier");
		
		System.out.println(c);
		
		ctx.close();
	}

}
