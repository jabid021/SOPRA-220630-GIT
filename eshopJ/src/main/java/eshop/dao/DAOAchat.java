package eshop.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import eshop.model.Achat;

@Repository
@Transactional
public class DAOAchat implements IDAOAchat {

	@PersistenceContext
	private EntityManager em;
	
	
	@Override
	public Achat findById(Integer id) {
		Achat m = null;
		try {
			m = em.find(Achat.class, id);
		}
		catch(Exception e) {e.printStackTrace();}
		return m;
	}

	@Override
	public List<Achat> findAll() {
		List<Achat> personnes =new ArrayList();
		try {

			personnes = em.createQuery("from Achat").getResultList();
		}catch(Exception e) {e.printStackTrace();}
		return personnes;
	}

	@Override
	public Achat save(Achat p) {
		try 
		{
			p = em.merge(p);
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		return p;

	}

	@Override
	public void delete(Integer id) {

		try 
		{
			Achat m = em.find(Achat.class, id);
			em.remove(m);
		}
		catch (Exception ex) {
			ex.printStackTrace();
			
		}
	}
}
