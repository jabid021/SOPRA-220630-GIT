package gEvent.dao;

import java.util.List;

import gEvent.model.Competition;
import gEvent.model.Evenement;
import gEvent.model.Festival;

public interface IDAOEvenement extends IDAO<Evenement,Integer>{
	public List<Competition> findAllCompetition();
	
	public Competition findByIdWithParticipations(Integer id);
	
	public Evenement findByIdWithSpectateurs(Integer id);
	
	public Festival findByIdWithPrestations(Integer id);
	
	
}
