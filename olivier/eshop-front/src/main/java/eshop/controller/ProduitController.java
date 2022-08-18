package eshop.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import eshop.model.Produit;
import eshop.service.FournisseurService;
import eshop.service.ProduitService;

@Controller
@RequestMapping("/produit")
public class ProduitController {

	@Autowired
	private ProduitService produitService;
	@Autowired
	private FournisseurService fournisseurService;

	@GetMapping("")
	public String list(Model model,HttpSession session) {
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
		model.addAttribute("fournisseurs", fournisseurService.getAll());
		model.addAttribute("produit", produit);
		return "produit/edit";
	}

	@PostMapping("/save")
	public String save(Model model,@Valid @ModelAttribute Produit produit,BindingResult br) {
		if(br.hasErrors()) {
			return goEdit(produit, model);
		}
		if (produit.getFournisseur() != null && produit.getFournisseur().getId() == null) {
			produit.setFournisseur(null);
		}
		if (produit.getId() == null) {
			produitService.create(produit);
		} else {
			produitService.update(produit);
		}
		return "redirect:/produit";
	}

}
