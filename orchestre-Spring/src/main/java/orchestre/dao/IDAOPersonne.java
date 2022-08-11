package orchestre.dao;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import orchestre.model.Personne;

public interface IDAOPersonne extends JpaRepository<Personne,Integer> {

	@Query("SELECT p from Personne p where p.prenom=:prenom")
	public Personne seConnecter(@Param("prenom")String prenom);
	

	public List<Personne> findByPrenom(String prenom,Pageable p);
	
	
	public Personne findByLoginAndPassword(String login,String password);
	
	

}
