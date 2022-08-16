package eshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import eshop.model.Produit;
import eshop.service.ProduitService;

@Controller
@RequestMapping("/produit")
public class ProduitController {

	@Autowired
	private ProduitService produitService;

	@GetMapping("")
	public String list(Model model) {
		model.addAttribute("produits", produitService.getAll());
		return "produit/list";
	}

	@GetMapping("/delete")
	public String delete(@RequestParam Integer id, Model model) {
		produitService.deleteById(id);
		return "redirect:/produit"; // apres redirect=>URL!!
	}

	@GetMapping("/edit")
	public String edit(@RequestParam Integer id, Model model) {
		return goEdit(produitService.getById(id), model);
	}

	@GetMapping("/add")
	public String add(Model model) {
		return goEdit(new Produit(), model);
	}

	private String goEdit(Produit produit, Model model) {
		model.addAttribute("produit", produit);
		return "produit/edit";
	}

	@PostMapping("/save")
	public String save(Model model, @ModelAttribute Produit produit) {
		if (produit.getId() == null) {
			produitService.create(produit);
		} else {
			produitService.update(produit);
		}
		return "redirect:/produit";
	}

}
