package orchestre.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import orchestre.model.IMusicien;

public class TestAOP {

	
	
	
	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:application-context.xml");

		//ClassMetier c = (ClassMetier) ctx.getBean("classMetier");
		IMusicien g = (IMusicien) ctx.getBean("guitariste");
		//c.demo();
		
		//c.demo2(false);
		
		g.toString();
		
		System.out.println("Fin d'app");
		ctx.close();
	}

}
