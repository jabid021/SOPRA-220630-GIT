package gEvent.dao;

import java.util.List;

import gEvent.model.Compte;
import gEvent.model.User;

public interface IDAOCompte extends IDAO<Compte,Integer>{

	public Compte seConnecter(String login,String password);
	
	
	public Compte findByIdWithSpectateurs(Integer idUser);
	
	public Compte findByIdWithParticipations(Integer idUser);
	
	public Compte findByIdWithGagnants(Integer idUser);
	
	public List<User> findAllUsers();
}
