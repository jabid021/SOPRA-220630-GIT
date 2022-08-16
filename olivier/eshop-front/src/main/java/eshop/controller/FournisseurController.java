package eshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import eshop.model.Fournisseur;
import eshop.service.FournisseurService;

@Controller
@RequestMapping("/fournisseur")
public class FournisseurController {

	@Autowired
	private FournisseurService fournisseurService;

	@GetMapping("")
	public String getAll(Model model) {
		model.addAttribute("fournisseurs", fournisseurService.getAll());
		return "fournisseur/list";
	}

	@GetMapping("/edit")
	public String edit(@RequestParam Integer id, Model model) {
		return goEdit(fournisseurService.getById(id), model);
	}

	@GetMapping("/add")
	public String add(Model model) {
		return goEdit(new Fournisseur(), model);
	}

	private String goEdit(Fournisseur fournisseur, Model model) {
		model.addAttribute("fournisseur", fournisseur);
		return "fournisseur/edit";
	}

	@GetMapping("/delete")
	public String delete(@RequestParam Integer id) {
		fournisseurService.deleteById(id);
		return "redirect:/fournisseur";
	}

	@PostMapping("/save")
	public String save(@ModelAttribute Fournisseur fournisseur, Model model) {
		if (fournisseur.getId() == null) {
			fournisseurService.create(fournisseur);
		} else {
			fournisseurService.update(fournisseur);
		}
		return "redirect:/fournisseur";
	}
}
