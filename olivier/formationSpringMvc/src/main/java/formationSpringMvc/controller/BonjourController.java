package formationSpringMvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import formationSpringMvc.model.Personne;

@Controller
@RequestMapping("/bonjour")
public class BonjourController {

	@GetMapping("")
	public String formulaire() {
		return "bonjour/form";
	}

	@PostMapping("")
	public String bonjour(Model model, @ModelAttribute Personne personne) {
		// public String bonjour(Model model, @RequestParam String prenom, @RequestParam
		// String nom) {
//		model.addAttribute("prenom", prenom);
//		model.addAttribute("nom", nom);
//		Personne personne = new Personne(prenom, nom);
		if (personne.getPrenom() == null || personne.getPrenom().isEmpty()) {
			model.addAttribute("error", "true");
			return "bonjour/form";
		}
		model.addAttribute("personne", personne);
		return "bonjour/bonjour";
	}
}
