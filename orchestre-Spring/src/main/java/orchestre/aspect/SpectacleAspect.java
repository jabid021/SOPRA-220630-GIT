package orchestre.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class SpectacleAspect {

	
	
	@Pointcut("execution(public void orchestre.model.Guitariste.jouer(..))")
	public void aspectJouer() {}
	
	
	@Before("aspectJouer()")
	public void install() 
	{
		System.out.println("Le public s'installe");
	}

	
	@After("aspectJouer()")
	public void applaudir() 
	{
		System.out.println("Le public applaudit !");
	}
	
	@AfterThrowing("aspectJouer()")
	public void tomates() 
	{
		System.out.println("Le public jette des tomates !");
	}
}
