package orchestre.aspect;

import org.aspectj.lang.ProceedingJoinPoint;

public class AspectDemo {

	public void lancerAvantDemo() 
	{
		System.out.println("Se lance avant");
	}
	
	public void lancerApresDemo() 
	{
		System.out.println("Se lance apres");
	}
	
	public void lancerAutoursDemo(ProceedingJoinPoint pj) throws Throwable
	{
		System.out.println("Se lance juste au dessus");
		pj.proceed();
		System.out.println("Se lance juste en dessous");
	}
	
	

	public void lancerDemo2Succes(String varRetour) 
	{
		System.out.println("Se lance apres succes, msg : "+varRetour);
	}
	public void lancerDemo2Echec() 
	{
		System.out.println("Se lance apres echec");
	}
	
	
	public void interceptToString() 
	{
		System.out.println("Se lance apres un toString Guitariste !");
	}
}