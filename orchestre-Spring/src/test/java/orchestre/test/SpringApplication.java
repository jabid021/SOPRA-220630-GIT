package orchestre.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import orchestre.config.AppConfig;

public class SpringApplication {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		//ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:application-context.xml");
		ctx.getBeanFactory().createBean(Test.class).run(args);
		ctx.close();
		

	}

}
