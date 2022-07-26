package eshop.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import eshop.model.Fournisseur;
import eshop.model.Produit;

public interface IDAOProduit extends JpaRepository<Produit, Integer> {

	@Query("SELECT p from Produit p where p.libelle=:lib")
	public List<Produit> findParLib(@Param("lib") String libelle);

	@Query("SELECT p from Produit p where p.libelle like %:lib%")
	public List<Produit> findByLibelleRessemble(@Param("lib") String libelle);

	public List<Produit> findByLibelleContaining(String lib);

	public List<Produit> findByLibelle(String lib);

	public List<Produit> findByPrixBetween(double a, double b);

	@Modifying
	@Transactional
	@Query("delete from Produit p where p.fournisseur=:fournisseur")
	public void deleteByFournisseur(@Param("fournisseur") Fournisseur fournisseur);
}
