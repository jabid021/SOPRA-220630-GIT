package eshop.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import eshop.model.Produit;

@Repository
@Transactional
public class DAOProduit implements IDAOProduit {

	@PersistenceContext
	private EntityManager em;
	
	
	@Override
	public Produit findById(Integer id) {
		Produit m = null;
		try {
			m = em.find(Produit.class, id);
		}
		catch(Exception e) {e.printStackTrace();}
		return m;
	}

	@Override
	public List<Produit> findAll() {
		List<Produit> personnes =new ArrayList();
		try {

			personnes = em.createQuery("from Produit").getResultList();
		}catch(Exception e) {e.printStackTrace();}
		return personnes;
	}

	@Override
	public Produit save(Produit p) {
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
			Produit m = em.find(Produit.class, id);
			em.remove(m);
		}
		catch (Exception ex) {
			ex.printStackTrace();
			
		}
	}
}
