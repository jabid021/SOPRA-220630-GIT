package eshop.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import eshop.context.Singleton;
import eshop.model.Personne;

public class DAOPersonne implements IDAOPersonne {



	@Override
	public Personne findById(Integer id) {
		Personne m = null;
		EntityManager em = null;
		try {
			em = Singleton.getInstance().getEmf().createEntityManager();
			m = em.find(Personne.class, id);
		}
		catch(Exception e) {e.printStackTrace();}
		finally {
			if(em!=null) {em.close();}
		}

		return m;
	}

	@Override
	public List<Personne> findAll() {
		List<Personne> personnes =new ArrayList();
		EntityManager em = null;
		try {

			em = Singleton.getInstance().getEmf().createEntityManager();
			personnes = em.createQuery("from Personne").getResultList();
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
	public Personne save(Personne p) {

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
			Personne m = em.find(Personne.class, id);
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
	public Personne seConnecter(String login, String password) {
		Personne p = null;
		try {
			EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
			p = (Personne) em.createQuery("SELECT p from Personne p where p.login=:login and p.password=:password").setParameter("login",login).setParameter("password",password).getSingleResult();
		}
		catch(Exception e) {e.printStackTrace();}
		return p;
	}
}
