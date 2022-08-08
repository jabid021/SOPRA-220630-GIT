package gEvent.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import gEvent.context.Singleton;
import gEvent.model.Compte;
import gEvent.model.Festival;
import gEvent.model.User;

public class DAOCompte implements IDAOCompte {


	@Override
	public Compte findById(Integer id) {
		Compte m = null;
		EntityManager em = null;
		try {
			em = Singleton.getInstance().getEmf().createEntityManager();
			m = em.find(Compte.class, id);
		}
		catch(Exception e) {e.printStackTrace();}
		finally {
			if(em!=null) {em.close();}
		}

		return m;
	}

	@Override
	public List<Compte> findAll() {
		List<Compte> personnes =new ArrayList();
		EntityManager em = null;
		try {

			em = Singleton.getInstance().getEmf().createEntityManager();
			personnes = em.createQuery("from Compte").getResultList();
		}catch(Exception e) {e.printStackTrace();}
		finally {
			if(em!=null) 
			{
				em.close();
			}
		}
		return personnes;
	}

	@Override
	public Compte save(Compte p) {

		EntityManager em = null;
		EntityTransaction tx = null;
		try 
		{
			em = Singleton.getInstance().getEmf().createEntityManager();
			tx=em.getTransaction();
			tx.begin();
			p = em.merge(p);
			tx.commit();
		}
		catch (Exception ex) {
			ex.printStackTrace();
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
		}
		finally 
		{
			if(em!=null) 
			{
				em.close();
			}
		}
		return p;

	}

	@Override
	public void delete(Integer id) {

		EntityManager em = null;
		EntityTransaction tx = null;
		try 
		{
			em = Singleton.getInstance().getEmf().createEntityManager();
			tx=em.getTransaction();
			tx.begin();
			Compte m = em.find(Compte.class, id);
			em.remove(m);
			tx.commit();
		}
		catch (Exception ex) {
			ex.printStackTrace();
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
		}
		finally 
		{
			if(em!=null) 
			{
				em.close();
			}
		}
	
	}

	@Override
	public Compte seConnecter(String login, String password) {
		Compte connected = null;
		EntityManager em = null;
		try {

			em = Singleton.getInstance().getEmf().createEntityManager();
			Query q = em.createQuery("SELECT c from Compte c where c.login=:log and c.password=:pass");
			q.setParameter("log", login);
			q.setParameter("pass",password);
			
			connected= (Compte) q.getSingleResult();
		
			//connected=(Compte) em.createQuery("SELECT c from Compte c where c.login=:log and c.password=:pass").setParameter("log", login).setParameter("pass",password).getSingleResult();
			
		}catch(Exception e) {e.printStackTrace();}
		finally {
			if(em!=null) 
			{
				em.close();
			}
		}
		return connected;
	}

	//Ne sert a rien, on peut deja retrouver dans le DAOSpectateur tous les evenements qu'un user à suivi
	@Override
	public Compte findByIdWithSpectateurs(Integer idUser) {
		Compte compte =null;
		EntityManager em = null;
		try {

			em = Singleton.getInstance().getEmf().createEntityManager();
			compte = (Compte) em.createQuery("SELECT u from User u  join fetch u.spectateurs where u.id=:id").setParameter("id", idUser).getSingleResult();
		}catch(Exception e) {e.printStackTrace();}
		finally {
			if(em!=null) 
			{
				em.close();
			}
		}
		return compte;

	}

	//Ne sert a rien, on peut deja retrouver dans le DAOParticipation toutes les competitions auxquelles un user à participé
	@Override
	public Compte findByIdWithParticipations(Integer idUser) {
		Compte compte =null;
		EntityManager em = null;
		try {

			em = Singleton.getInstance().getEmf().createEntityManager();
			compte = (Compte) em.createQuery("SELECT u from User u  join fetch u.participations where u.id=:id").setParameter("id", idUser).getSingleResult();
		}catch(Exception e) {e.printStackTrace();}
		finally {
			if(em!=null) 
			{
				em.close();
			}
		}
		return compte;
	
		
	}

	
	//Ne sert a rien, on peut deja retrouver dans le DAOEvenement toutes les competitions gagnées par un user
	@Override
	public Compte findByIdWithGagnants(Integer idUser) {
		Compte compte =null;
		EntityManager em = null;
		try {

			em = Singleton.getInstance().getEmf().createEntityManager();
			compte = (Compte) em.createQuery("SELECT u from User u  join fetch u.gagnants where u.id=:id").setParameter("id", idUser).getSingleResult();
		}catch(Exception e) {e.printStackTrace();}
		finally {
			if(em!=null) 
			{
				em.close();
			}
		}
		return compte;
	}

	@Override
	public List<User> findAllUsers() {
		List<User> personnes =new ArrayList();
		EntityManager em = null;
		try {

			em = Singleton.getInstance().getEmf().createEntityManager();
			personnes = em.createQuery("from User").getResultList();
		}catch(Exception e) {e.printStackTrace();}
		finally {
			if(em!=null) 
			{
				em.close();
			}
		}
		return personnes;
	}

}
