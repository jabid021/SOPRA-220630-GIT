package gEvent.dao;

import gEvent.model.Compte;

public interface IDAOCompte extends IDAO<Compte,Integer>{

	public Compte seConnecter(String login,String password);
}
