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
		Competition competition =null;
		EntityManager em = null;
		try {

			em = Singleton.getInstance().getEmf().createEntityManager();
			competition = (Competition) em.createQuery("SELECT c from Competition c join fetch c.participants where c.id=:id").setParameter("id", id).getSingleResult();
		}catch(Exception e) {e.printStackTrace();}
		finally {
			if(em!=null) 
			{
				em.close();
			}
		}
		return competition;
	}

	@Override
	public Evenement findByIdWithSpectateurs(Integer id) {
		Evenement evenement =null;
		EntityManager em = null;
		try {

			em = Singleton.getInstance().getEmf().createEntityManager();
			evenement = (Evenement) em.createQuery("SELECT e from Evenement e join fetch e.spectateurs where e.id=:id").setParameter("id", id).getSingleResult();
		}catch(Exception e) {e.printStackTrace();}
		finally {
			if(em!=null) 
			{
				em.close();
			}
		}
		return evenement;
	}

	@Override
	public Festival findByIdWithPrestations(Integer id) {
		Festival festival =null;
		EntityManager em = null;
		try {

			em = Singleton.getInstance().getEmf().createEntityManager();
			festival = (Festival) em.createQuery("SELECT f from Festival f join fetch f.prestations where f.id=:id").setParameter("id", id).getSingleResult();
		}catch(Exception e) {e.printStackTrace();}
		finally {
			if(em!=null) 
			{
				em.close();
			}
		}
		return festival;
	}

	@Override
	public List<Competition> findAllByGagnant(Integer idUser) {
		List<Competition> competitions =new ArrayList();
		EntityManager em = null;
		try {

			em = Singleton.getInstance().getEmf().createEntityManager();
			competitions = em.createQuery("SELECT c from Competition c where c.gagnant.id=:id").setParameter("id", idUser).getResultList();
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
	public List<Festival> findAllFestival() {
		List<Festival> festivals =new ArrayList();
		EntityManager em = null;
		try {

			em = Singleton.getInstance().getEmf().createEntityManager();
			festivals = em.createQuery("from Festival").getResultList();
		}catch(Exception e) {e.printStackTrace();}
		finally {
			if(em!=null) 
			{
				em.close();
			}
		}
		return festivals;
	
	}

}
