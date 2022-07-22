package model;

import java.util.ArrayList;
import java.util.List;

public class Intervenant {
	
	private Integer id;
	private String nom ;
	
	private List<Talent> talents = new ArrayList();

	public Intervenant(String nom) {
		this.nom = nom;
	}
	
	
	public Intervenant(Integer id,String nom) {
		this.nom = nom;
		this.id=id;
	}
	

	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}

	

	public List<Talent> getTalents() {
		return talents;
	}


	public void setTalents(List<Talent> talents) {
		this.talents = talents;
	}

	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String toString() {
		return "Intervenant [id="+id+",nom=" + nom +" a comme talent " + talents + "]";
	
	
}
}