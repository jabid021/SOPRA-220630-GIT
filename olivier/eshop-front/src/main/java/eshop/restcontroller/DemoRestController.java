package eshop.restcontroller;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import eshop.demoRest.Adresse;
import eshop.demoRest.Personne;

@RestController
@RequestMapping("/api/demoRest")
public class DemoRestController {

	@GetMapping("/hello")
	public String hello() {
		return "hello world";
	}

	@GetMapping("/hello/olivier")
	public Personne helloOlivier() {
		return new Personne("olivier", "gozlan", new Adresse("chez olivier"));
	}

	@GetMapping("/hello/list")
	public List<Personne> hellos() {
		return Arrays.asList(new Personne("aa", "bb"), 
				new Personne("olivier", "gozlan", new Adresse("chez olivier")));
	}
	
	//Get	=>recuperation
	//Post	=>creation
	//Put	=>remplacement
	//Patch	=>modification partielle
	//Delete=>suppression
}
