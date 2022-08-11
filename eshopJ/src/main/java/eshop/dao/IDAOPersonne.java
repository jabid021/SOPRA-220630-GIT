package eshop.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import eshop.model.Fournisseur;
import eshop.model.Personne;

public interface IDAOPersonne extends JpaRepository<Personne,Integer> {

	@Query("from Fournisseur")
	public List<Fournisseur> findAllFournisseur();
}
