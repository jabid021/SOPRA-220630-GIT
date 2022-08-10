package orchestre.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import orchestre.model.Personne;

@Repository
@Transactional
public class DAOPersonne implements IDAOPersonne {

	@PersistenceContext
	private EntityManager em;

	@Override
	public Personne findById(Integer id) {
		Personne m = null;
		try {
			m = em.find(Personne.class, id);
		}
		catch(Exception e) {e.printStackTrace();}

		return m;
	}

	@Override
	public List<Personne> findAll() {
		List<Personne> personnes =new ArrayList();
		try {
			personnes = em.createQuery("from Personne").getResultList();
		}catch(Exception e) {e.printStackTrace();}
		return personnes;
	}

	@Override
	public Personne save(Personne p) {
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
			Personne m = em.find(Personne.class, id);
			em.remove(m);
		}
		catch (Exception ex) {
			ex.printStackTrace();
			
		}
	}

	@Override
	public Personne seConnecter(String prenom) {
		Personne p = null;
		try {
			p = (Personne) em.createQuery("SELECT p from Personne p where p.prenom=:prenom").setParameter("prenom",prenom).getSingleResult();
		}
		catch(Exception e) {e.printStackTrace();}
		return p;
	}



}
