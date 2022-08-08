package eshop.dao;

import java.util.List;

import eshop.model.Fournisseur;
import eshop.model.Personne;

public interface IDAOPersonne extends IDAO<Personne,Integer> {

	
	public Personne seConnecter(String login,String password);
	public List<Fournisseur> findAllFournisseur();
}
