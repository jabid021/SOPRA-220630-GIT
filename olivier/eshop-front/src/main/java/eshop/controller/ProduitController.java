package eshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
		return "redirect:/produit"; //apres redirect=>URL!!
	}
}
