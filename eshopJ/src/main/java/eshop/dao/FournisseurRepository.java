package eshop.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import eshop.model.Fournisseur;

public interface FournisseurRepository extends JpaRepository<Fournisseur, Integer> {

}
