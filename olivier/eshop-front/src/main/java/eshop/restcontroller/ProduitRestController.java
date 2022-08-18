package eshop.restcontroller;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.ReflectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.annotation.JsonView;

import eshop.exception.ProduitException;
import eshop.model.Produit;
import eshop.model.jsonview.Base;
import eshop.model.jsonview.JsonViews;
import eshop.model.jsonview.ProduitWithFournisseur;
import eshop.service.FournisseurService;
import eshop.service.ProduitService;

@RestController
@RequestMapping("/api/produit")
public class ProduitRestController {

	@Autowired
	private ProduitService produitService;
	@Autowired
	private FournisseurService fournisseurService;

	@GetMapping("")
	@JsonView(JsonViews.ProduitWithFournisseur.class)
	public List<Produit> getAll() {
		return produitService.getAll();
	}

	@GetMapping("/{id}")
	@JsonView(JsonViews.ProduitWithFournisseur.class)
	public Produit getById(@PathVariable Integer id) {
		// try {
		return produitService.getById(id);
//		} catch (ProduitException ex) {
//			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
//		}
	}

	@PostMapping("")
	@JsonView(JsonViews.Base.class)
	public Produit create(@Valid @RequestBody Produit produit, BindingResult br) {
		if (br.hasErrors()) {
			throw new ProduitException();
		}
		return produitService.create(produit);
	}

	@PutMapping("/{id}")
	@JsonView(JsonViews.Base.class)
	public Produit update(@Valid @RequestBody Produit produit, BindingResult br, @PathVariable Integer id) {
		if (br.hasErrors()) {
			throw new ProduitException();
		}
		Produit produitEnBase = produitService.getById(id);
		if (produitEnBase != null) {
			produit.setId(id);
			return produitService.update(produit);
		}
		return null;
	}

	@PatchMapping("/{id}")
	@JsonView(JsonViews.Base.class)
	public Produit partialUpdate(@RequestBody Map<String, Object> fields, @PathVariable Integer id) {
		Produit produit = produitService.getById(id);
		fields.forEach((k, v) -> {
			if (k.equals("fournisseur")) {
				if (v == null) {
					produit.setFournisseur(null);
				} else {
					System.out.println(v);
					Map<String, Object> map = (Map<String, Object>) v;
					produit.setFournisseur(fournisseurService.getById((Integer) map.get("id")));
				}
			} else {
				Field field = ReflectionUtils.findField(Produit.class, k);
				ReflectionUtils.makeAccessible(field);
				ReflectionUtils.setField(field, produit, v); // ne fonctionne que pour les types standards
			}
		});
		return produitService.update(produit);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) {
		produitService.deleteById(id);
	}

}
