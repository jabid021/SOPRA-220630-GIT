package eshop.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import eshop.model.Fournisseur;

public interface FournisseurRepository extends JpaRepository<Fournisseur, Integer> {

	@Query("select f from Fournisseur f left join fetch f.produits where f.id=:id")
	Optional<Fournisseur> findByIdWithProduit(@Param("id") Integer id);
}
