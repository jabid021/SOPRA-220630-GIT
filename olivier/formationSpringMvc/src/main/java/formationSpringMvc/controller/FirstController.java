package formationSpringMvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/demo")
public class FirstController {

	// @RequestMapping("/hello")
	@GetMapping("/hello")
	public String hello(Model model, 
			@RequestParam String nom) {
		model.addAttribute("nom", nom);
		return "hello";
	}

	@RequestMapping(path = "/bye", method = RequestMethod.GET)
	public String bye() {
		return "bye";
	}
}
