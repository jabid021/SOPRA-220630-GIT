package eshop.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import eshop.model.Produit;
import eshop.model.jsonview.Base;
import eshop.model.jsonview.JsonViews;
import eshop.model.jsonview.ProduitWithFournisseur;
import eshop.service.ProduitService;

@RestController
@RequestMapping("/api/produit")
public class ProduitRestController {

	@Autowired
	private ProduitService produitService;

	@GetMapping("")
	@JsonView(JsonViews.ProduitWithFournisseur.class)
	public List<Produit> getAll() {
		return produitService.getAll();
	}

	@GetMapping("/{id}")
	@JsonView(JsonViews.ProduitWithFournisseur.class)
	public Produit getById(@PathVariable Integer id) {
		return produitService.getById(id);
	}
}
