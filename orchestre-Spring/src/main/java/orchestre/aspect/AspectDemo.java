package orchestre.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AspectDemo {

	
	@Pointcut("execution(public void orchestre.model.ClassMetier.demo())")
	public void demoPointCut() {}
	
	@Pointcut("execution(public String orchestre.model.ClassMetier.demo2(boolean))")
	public void demo2PointCut() {}
	
	
	@Before("demoPointCut()")
	public void lancerAvantDemo() 
	{
		System.out.println("Se lance avant");
	}
	
	@After("demoPointCut()")
	public void lancerApresDemo() 
	{
		System.out.println("Se lance apres");
	}
	
	@Around("demoPointCut()")
	public void lancerAutoursDemo(ProceedingJoinPoint pj) throws Throwable
	{
		System.out.println("Se lance juste au dessus");
		pj.proceed();
		System.out.println("Se lance juste en dessous");
	}
	
	
	@AfterReturning(pointcut = "demo2PointCut() && args(param)", returning = "varRetour")
	public void lancerDemo2Succes(boolean param,String varRetour) 
	{
		System.out.println("Se lance apres succes "+param+" , msg : "+varRetour);
	}
	
	@AfterThrowing("demo2PointCut() && args(param)")
	public void lancerDemo2Echec(boolean param) 
	{
		System.out.println("Se lance apres echec car plante = "+param);
	}
	
	@AfterReturning(pointcut = "execution(public String orchestre.model.Guitariste.toString())", returning = "sortie")
	public void interceptToString(String sortie) 
	{
		System.out.println(sortie+"\nSe lance apres un toString Guitariste !");
	}
}
