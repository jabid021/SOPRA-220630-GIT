package test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Collections;

import model.Admin;
import model.Adresse;
import model.Competition;
import model.Festival;
import model.Intervenant;
import model.Prestation;
import model.Sport;
import model.Talent;
import model.User;

public class Test {

	public static void main(String[] args) {
	
		
		Admin admin = new Admin("admin","admin123");
		
		 
		Adresse a1= new Adresse("6","rue rougemont","75009","Paris");
		
		Adresse a2= new Adresse("2","route des tribunes","75016","Paris");
		
		Adresse a3= new Adresse("10","rue la Fayette","44000","Nantes");
		
		
		
		User user1 = new User("jabid1","toto123","Abid","Jordan",LocalDate.parse("1993-05-01"),"0123456789",a1);
		User user2 = new User("jabid2","toto123","Abid","Jordan",LocalDate.parse("1993-05-01"),"0123456789",a1);
		User user3 = new User("jabid3","toto123","Abid","Jordan",LocalDate.parse("1993-05-01"),"0123456789",a1);
		User user4 = new User("jabid4","toto123","Abid","Jordan",LocalDate.parse("1993-05-01"),"0123456789",a1);
		User user5 = new User("jabid5","toto123","Abid","Jordan",LocalDate.parse("1993-05-01"),"0123456789",a1);
		
		Competition compet1 = new Competition("Tournoi de Judo",LocalDate.parse("2022-07-18"),LocalTime.parse("15:00"),LocalDate.parse("2022-07-18"),LocalTime.parse("20:00"),0,Sport.Judo,a3);
		Collections.addAll(compet1.getParticipants(), user3,user4,user5);
		Collections.addAll(compet1.getSpectateurs(), user1,user2);
		compet1.setGagnant(user3);
		
		
		
		Intervenant i1 = new Intervenant("intervenant1");
		i1.getTalents().add(Talent.Chant);
		
		
		
		Intervenant i2 = new Intervenant("intervenant2");
		Collections.addAll(i2.getTalents(), Talent.Chant,Talent.Danse,Talent.Autre);

		
		
		Festival festival = new Festival("Festival Solidays",LocalDate.parse("2022-07-18"),LocalTime.parse("19:00"),LocalDate.parse("2022-07-21"),LocalTime.parse("20:00"),20,a2);
		Collections.addAll(festival.getSpectateurs(), user1, user2, user3, user4, user5);
		
		Prestation p1 = new Prestation(LocalDate.parse("2022-07-18"),LocalTime.parse("19:30"),LocalDate.parse("2022-07-18"),LocalTime.parse("19:55"),i1,festival);
		Prestation p2 = new Prestation(LocalDate.parse("2022-07-18"),LocalTime.parse("20:15"),LocalDate.parse("2022-07-18"),LocalTime.parse("23:30"),i2,festival);
		
		
		
		System.out.println("--------------Judo---------------");
		
		
		
		System.out.println(compet1);
		
		
		
		System.out.println("-------------------Festival--------------");
		
		System.out.println(festival);
	
		
		
	}

}
