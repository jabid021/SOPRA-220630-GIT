package eshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eshop.dao.FournisseurRepository;
import eshop.dao.IDAOPersonne;
import eshop.dao.IDAOProduit;
import eshop.exception.FournisseurException;
import eshop.model.Fournisseur;

@Service
public class FournisseurService {

	@Autowired
	private FournisseurRepository fournisseurRepo;
	@Autowired
	private IDAOProduit produitRepo;

	public List<Fournisseur> getAll() {
		return fournisseurRepo.findAll();
	}

	public Fournisseur getById(Integer id) {
		return fournisseurRepo.findById(id).orElseThrow(FournisseurException::new);
	}

	public Fournisseur getByIdWithProduits(Integer id) {
		return fournisseurRepo.findByIdWithProduit(id).orElseThrow(FournisseurException::new);
	}

	public Fournisseur create(Fournisseur fournisseur) {
		return fournisseurRepo.save(fournisseur);
	}

	public Fournisseur update(Fournisseur fournisseur) {
		return fournisseurRepo.save(fournisseur);
	}

	public void deleteById(Integer id) {
		produitRepo.deleteByFournisseur(getById(id));
		fournisseurRepo.deleteById(id);
	}
}
