package gEvent.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import gEvent.context.Singleton;
import gEvent.model.Competition;
import gEvent.model.Evenement;
import gEvent.model.Festival;


public class DAOEvenement implements IDAOEvenement {

	@Override
	public Evenement findById(Integer id) {
		Evenement ev = null;
		EntityManager em = null;
		try {
			em = Singleton.getInstance().getEmf().createEntityManager();
			ev = em.find(Evenement.class, id);
		}
		catch(Exception e) {e.printStackTrace();}
		finally {
			if(em!=null) {em.close();}
		}

		return ev;
	}

	@Override
	public List<Evenement> findAll() {
		List<Evenement> evenements =new ArrayList();
		EntityManager em = null;
		try {

			em = Singleton.getInstance().getEmf().createEntityManager();
			evenements = em.createQuery("from Evenement").getResultList();
		}catch(Exception e) {e.printStackTrace();}
		finally {
			if(em!=null) 
			{
				em.close();
			}
		}
		return evenements;
	}

	@Override
	public Evenement save(Evenement e) {
		EntityManager em = null;
		EntityTransaction tx = null;
		try 
		{
			em = Singleton.getInstance().getEmf().createEntityManager();
			tx=em.getTransaction();
			tx.begin();
			e = em.merge(e);
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
		return e;
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
			Evenement e = em.find(Evenement.class, id);
			em.remove(e);
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
	public List<Competition> findAllCompetition() {
		List<Competition> competitions =new ArrayList();
		EntityManager em = null;
		try {

			em = Singleton.getInstance().getEmf().createEntityManager();
			competitions = em.createQuery("from Competition").getResultList();
		}catch(Exception e) {e.printStackTrace();}
		finally {
			if(em!=null) 
			{
				em.close();
			}
		}
		return competitions;
	}

	@Override
	public Competition findByIdWithParticipations(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Evenement findByIdWithSpectateurs(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Festival findByIdWithPrestations(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}
