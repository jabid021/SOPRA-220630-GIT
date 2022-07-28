package gEvent.model;

import java.util.ArrayList;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Intervenant {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nom ;
	
	
	private List<Talent> talents = new ArrayList();

	public Intervenant() {}
	
	public Intervenant(String nom) {
		this.nom = nom;
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

	@Override
	public String toString() {
		return "Intervenant [id=" + id + ", nom=" + nom + "]";
	}


}