package gEvent.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import gEvent.context.Singleton;
import gEvent.model.Intervenant;

public class DAOIntervenant implements IDAOIntervenant {
	
	
	@Override
	public Intervenant findById(Integer id) {
		Intervenant i = null;
		EntityManager em = null;
		try {
			em = Singleton.getInstance().getEmf().createEntityManager();
			i = em.find(Intervenant.class, id);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (em != null) {
				em.close();
			}
		}

		return i;
	}

	@Override
	public List<Intervenant> findAll() {
		List<Intervenant> Intervenants = new ArrayList();
		EntityManager em = null;
		try {

			em = Singleton.getInstance().getEmf().createEntityManager();
			Intervenants = em.createQuery("from Intervenant").getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (em != null) {
				em.close();
			}
		}
		return Intervenants;
	}

	@Override
	public Intervenant save(Intervenant i) {

		EntityManager em = null;
		EntityTransaction tx = null;
		try {
			em = Singleton.getInstance().getEmf().createEntityManager();
			tx = em.getTransaction();
			tx.begin();
			i = em.merge(i);
			tx.commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
		} finally {
			if (em != null) {
				em.close();
			}
		}
		return i;

	}

	@Override
	public void delete(Integer id) {

		EntityManager em = null;
		EntityTransaction tx = null;
		try {
			em = Singleton.getInstance().getEmf().createEntityManager();
			tx = em.getTransaction();
			tx.begin();
			Intervenant i = em.find(Intervenant.class, id);
			em.remove(i);
			tx.commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
		} finally {
			if (em != null) {
				em.close();
			}
		}

	}
	

}
