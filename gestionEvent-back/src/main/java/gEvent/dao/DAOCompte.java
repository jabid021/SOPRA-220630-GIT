package gEvent.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import gEvent.context.Singleton;
import gEvent.model.Compte;

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

	@Override
	public Compte findByIdWithSpectateurs(Integer idUser) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Compte findByIdWithParticipations(Integer idUser) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Compte findByIdWithGagnants(Integer idUser) {
		// TODO Auto-generated method stub
		return null;
	}

}
