package eshop.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import eshop.model.Achat;
import eshop.model.Produit;

public interface IDAOAchat extends JpaRepository<Achat, Integer> {
	@Transactional
	@Modifying
	@Query("delete from Achat a where a.produit=:produit")
	public abstract void deleteByProduit(@Param("produit") Produit produit);

	@Transactional
	@Modifying
	@Query("delete from Achat a where a.produit.id=:id")
	void deleteByIdProduit(@Param("id") Integer id);

	@Transactional
	@Modifying
	@Query("update Achat a set a.produit=null where a.produit=:produit")
	int setNullToProduitByProduit(@Param("produit") Produit produit);
}
