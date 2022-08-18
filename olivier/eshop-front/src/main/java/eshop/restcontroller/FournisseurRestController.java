package eshop.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import eshop.model.Fournisseur;
import eshop.model.jsonview.JsonViews;
import eshop.service.FournisseurService;

@RestController
@RequestMapping("/api/fournisseur")
public class FournisseurRestController {

	@Autowired
	private FournisseurService fournisseurService;

	@JsonView(JsonViews.Base.class)
	@GetMapping("")
	public List<Fournisseur> getAll() {
		return fournisseurService.getAll();
	}

	@JsonView(JsonViews.Base.class)
	@GetMapping("/{id}")
	public Fournisseur getById(@PathVariable Integer id) {
		return fournisseurService.getById(id);
	}

	@JsonView(JsonViews.FournisseurWithProduits.class)
	@GetMapping("/{id}/produits")
	public Fournisseur getByIdWithProduit(@PathVariable Integer id) {
		return fournisseurService.getByIdWithProduits(id);
	}

}
