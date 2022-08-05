package eshop.dao;

import eshop.model.Personne;

public interface IDAOPersonne extends IDAO<Personne,Integer> {

	
	public Personne seConnecter(String login,String password);
}
