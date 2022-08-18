package eshop.restcontroller;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.annotation.JsonView;

import eshop.exception.FournisseurException;
import eshop.model.Adresse;
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
	public Fournisseur getByIdWithProduit(@PathVariable Integer id,
			@RequestParam(name = "var", required = false, defaultValue = "toto") String var) {

		System.out.println(var);
		return fournisseurService.getByIdWithProduits(id);
	}

	@ResponseStatus(code = HttpStatus.CREATED)
	@PostMapping("")
	@JsonView(JsonViews.Base.class)
	public Fournisseur create(@RequestBody Fournisseur fournisseur) {
		return fournisseurService.create(fournisseur);
	}

	@PutMapping("/{id}")
	@JsonView(JsonViews.Base.class)
	public Fournisseur update(@PathVariable Integer id, @RequestBody Fournisseur fournisseur) {
		try {
			fournisseurService.getById(id);
		} catch (FournisseurException ex) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		return fournisseurService.update(fournisseur);
	}

	@PatchMapping("/{id}")
	@JsonView(JsonViews.Base.class)
	public Fournisseur partialUpdate(@RequestBody Map<String, Object> fields, @PathVariable Integer id) {
		Fournisseur fournisseur = null;
		try {
			fournisseur = fournisseurService.getById(id);
		} catch (FournisseurException ex) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		Adresse adresse = fournisseur.getAdresse();
		final Fournisseur f = fournisseur;
		fields.forEach((k, v) -> {
			if (k.equals("adresse")) {
				((Map<String, Object>) v).forEach((key, value) -> {
					Field fieldAdresse = ReflectionUtils.findField(Adresse.class, key);
					ReflectionUtils.makeAccessible(fieldAdresse);
					ReflectionUtils.setField(fieldAdresse, adresse, value);
				});
				f.setAdresse(adresse);
			} else {
				Field field = ReflectionUtils.findField(Fournisseur.class, k);
				ReflectionUtils.makeAccessible(field);
				ReflectionUtils.setField(field, f, v);
			}
		});
		return fournisseurService.update(fournisseur);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Integer id) {
		fournisseurService.deleteById(id);
	}

}
