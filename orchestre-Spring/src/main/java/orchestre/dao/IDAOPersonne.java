package orchestre.dao;

import orchestre.model.Personne;

public interface IDAOPersonne extends IDAO<Personne,Integer> {

	
	public Personne seConnecter(String prenom);

}
