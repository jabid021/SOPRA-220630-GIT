package gEvent.test;

import java.util.List;

import javax.persistence.EntityManager;

import gEvent.context.Singleton;
import gEvent.model.Intervenant;
import gEvent.model.Prestation;

public class TestLazy {


	//Acces aux talents AVANT le em.close ❌
	//Impossible de faire des filtres sur les talents ❌
	public static List<Intervenant> showLazy()
	{
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();

		List<Intervenant> intervenants = em.createQuery("SELECT i from Intervenant i where i.talents = 'Chant'").getResultList();

		em.close();
		return intervenants;
	}


	//Acces aux talents AVANT le em.close ❌
	//Possible de faire des filtres sur les talents ✔
	//Les intervenants n'ayant pas de talents ne sont pas return ❌
	//Retourne des doublons si l'intervenant a plusieurs talents ❌
	public static List<Intervenant> showJoin()
	{
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();

		List<Intervenant> intervenants = em.createQuery("SELECT i from Intervenant i join i.talents t where t = 'Chant'").getResultList();

		em.close();
		return intervenants;
	}



	//Acces aux talents AVANT le em.close ❌
	//Possible de faire des filtres sur les talents ✔
	//Les intervenants n'ayant pas de talents ne sont pas return ❌
	//Retourne des doublons si l'intervenant a plusieurs talents ✔
	public static List<Intervenant> showJoinNoDoublons()
	{
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();

		List<Intervenant> intervenants = em.createQuery("SELECT distinct i from Intervenant i join i.talents t where t = 'Chant'").getResultList();

		em.close();
		return intervenants;
	}




	//Acces aux talents AVANT le em.close ❌
	//Possible de faire des filtres sur les talents ✔
	//Les intervenants n'ayant pas de talents sont  return ✔
	//Ne retourne pas de doublon si l'intervenant a plusieurs talents ✔
	public static List<Intervenant> showJoinNoDoublonsIntervenantsSansTalent()
	{
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();

		List<Intervenant> intervenants = em.createQuery("SELECT distinct i from Intervenant i left join i.talents t").getResultList();

		em.close();
		return intervenants;
	}




	//Acces aux talents APRES le em.close ✔
	//Possible de faire des filtres sur les talents ✔
	//Les intervenants n'ayant pas de talent sont  return ✔
	//ne retourne pas de doublon si l'intervenant a plusieurs talents ✔
	public static List<Intervenant> showJoinNoDoublonsIntervenantsSansTalentAfterClose()
	{
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();

		List<Intervenant> intervenants = em.createQuery("SELECT distinct i from Intervenant i left join fetch i.talents t").getResultList();

		em.close();
		return intervenants;
	}



	//Acces aux prestations APRES le em.close ✔
	//Possible de faire des filtres sur les prestations ✔
	//Les intervenants n'ayant pas de prestation sont  return ✔
	//Ne retourne pas de doublons si l'intervenant a plusieurs prestations ✔
	public static List<Intervenant> showJoinNoDoublonsIntervenantsSansPrestationAfterClose()
	{
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();

		List<Intervenant> intervenants = em.createQuery("SELECT distinct i from Intervenant i left join fetch i.prestations p").getResultList();

		em.close();
		return intervenants;
	}



	//Acces aux listes APRES le em.close ✔
	//Possible de faire des filtres sur les listes ✔
	//Les intervenants n'ayant pas de prestations ou pas de talents sont return ✔
	//Ne retourne pas de doublon si l'intervenant a plusieurs prestations ou plusieurs talents ✔
	public static List<Intervenant> showJoinNoDoublonsIntervenantsSansPrestationNiTalentsAfterCloseNotWorking()
	{
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();

		List<Intervenant> intervenants = em.createQuery("SELECT distinct i from Intervenant i left join fetch i.prestations p left join fetch i.talents t").getResultList();

		em.close();
		return intervenants;
	}

	
	

	//Acces aux listes APRES le em.close ✔
	//Possible de faire des filtres sur les listes ✔
	//Les intervenants n'ayant pas de prestations ou pas de talents sont return ✔
	//Ne retourne pas de doublon si l'intervenant a plusieurs prestations ou plusieurs talents ✔
	public static List<Intervenant> showJoinNoDoublonsIntervenantsSansPrestationNiTalentsAfterCloseWorking()
	{
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();

		List<Intervenant> intervenants = em.createQuery("SELECT distinct i from Intervenant i left join fetch i.prestations").getResultList();
		intervenants = em.createQuery("SELECT distinct i from Intervenant i left join fetch i.talents t").getResultList();
		em.close();
		return intervenants;
	}



	public static void main(String[] args) {


		List<Intervenant> intervenants = showJoinNoDoublonsIntervenantsSansPrestationNiTalentsAfterCloseWorking();

		for(Intervenant i : intervenants) 
		{
			System.out.println(i);
			System.out.println("Liste des prestations : ");
			for(Prestation p : i.getPrestations()) {System.out.println(p);}
			System.out.println("Liste des talents : ");

			if(i.getTalents().isEmpty()) {System.out.println("Cet intervenant n'a pas de talent !");}
			System.out.println(i.getTalents());
		}

		Singleton.getInstance().getEmf().close();



	}

}
