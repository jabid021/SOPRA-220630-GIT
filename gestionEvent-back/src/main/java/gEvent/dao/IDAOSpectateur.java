package gEvent.dao;

import java.util.List;

import gEvent.model.Spectateur;

public interface IDAOSpectateur extends IDAO<Spectateur,Integer>{

	public List<Spectateur> findAllByUser(Integer idUser); 
}
