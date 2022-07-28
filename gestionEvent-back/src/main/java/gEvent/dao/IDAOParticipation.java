package gEvent.dao;

import java.util.List;

import gEvent.model.Participation;

public interface IDAOParticipation extends IDAO<Participation,Integer>{

	public List<Participation> findAllByUser(Integer idUser); 
}
