package eshop.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import eshop.context.Singleton;
import eshop.model.Achat;

public class DAOAchat implements IDAOAchat {



	@Override
	public Achat findById(Integer id) {
		Achat m = null;
		EntityManager em = null;
		try {
			em = Singleton.getInstance().getEmf().createEntityManager();
			m = em.find(Achat.class, id);
		}
		catch(Exception e) {e.printStackTrace();}
		finally {
			if(em!=null) {em.close();}
		}

		return m;
	}

	@Override
	public List<Achat> findAll() {
		List<Achat> personnes =new ArrayList();
		EntityManager em = null;
		try {

			em = Singleton.getInstance().getEmf().createEntityManager();
			personnes = em.createQuery("from Achat").getResultList();
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
	public Achat save(Achat p) {

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
			Achat m = em.find(Achat.class, id);
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
}
