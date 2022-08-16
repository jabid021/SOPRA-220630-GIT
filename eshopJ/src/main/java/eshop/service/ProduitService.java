package eshop.service;

import java.util.List;

import javax.sound.midi.SysexMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eshop.dao.IDAOAchat;
import eshop.dao.IDAOProduit;
import eshop.exception.ProduitException;
import eshop.model.Produit;

@Service
public class ProduitService {

	@Autowired
	private IDAOProduit produitRepo;

	@Autowired
	private IDAOAchat achatRepo;

	public Produit getById(Integer id) {
		// return produitRepo.findById(id).orElseThrow(ProduitException::new);
		return produitRepo.findById(id).orElseThrow(() -> {
			throw new ProduitException("id produit inconnu");
		});
	}

	public List<Produit> getAll() {
		// produitRepo.findAll().forEach(System.out::println);
//		produitRepo.findAll().forEach((p) -> {
//			System.out.println(p);
//		});
		return produitRepo.findAll();
	}

	public Produit create(Produit produit) {
		if (produit.getLibelle() == null || produit.getLibelle().isEmpty()) {
			throw new ProduitException("libelle obligatoire");
		}
		if (produit.getPrix() <= 0) {
			throw new ProduitException("prix negatif ou nul");
		}
		return produitRepo.save(produit);
	}

	public Produit update(Produit produit) {
		if (produit.getLibelle() == null || produit.getLibelle().isEmpty()) {
			throw new ProduitException("libelle obligatoire");
		}
		if (produit.getPrix() <= 0) {
			throw new ProduitException("prix negatif ou nul");
		}
		Produit produitEnBase = getById(produit.getId());
		produitEnBase.setLibelle(produit.getLibelle());
		produitEnBase.setPrix(produit.getPrix());
		return produitRepo.save(produitEnBase);
	}

	public void delete(Produit produit) {
		achatRepo.setNullToProduitByProduit(produit);
		// achatRepo.deleteByProduit(produit);
		produitRepo.delete(produit);
	}

	public void deleteById(Integer id) {
		delete(getById(id));
	}
}
