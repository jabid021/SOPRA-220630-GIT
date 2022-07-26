package demoJPA.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Matiere {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String libelle;
	private int code;
	private int duree;
	
	@ManyToMany
	private List<Outil> outils=new ArrayList();
	
	@OneToMany(mappedBy = "matiere")
	private List<Module> modules;
	
	@OneToMany(mappedBy="matiere")
	private List<Stagiaire> apprenants;
	
	public Matiere() {
	
	}

	public Matiere(String libelle, int code, int duree) {
		this.libelle = libelle;
		this.code = code;
		this.duree = duree;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public int getDuree() {
		return duree;
	}

	public void setDuree(int duree) {
		this.duree = duree;
	}
	

	public List<Module> getModules() {
		return modules;
	}

	public void setModules(List<Module> modules) {
		this.modules = modules;
	}
	
	

	public List<Stagiaire> getApprenants() {
		return apprenants;
	}

	public void setApprenants(List<Stagiaire> apprenants) {
		this.apprenants = apprenants;
	}

	public List<Outil> getOutils() {
		return outils;
	}

	public void setOutils(List<Outil> outils) {
		this.outils = outils;
	}

	@Override
	public String toString() {
		return "Matiere [id=" + id + ", libelle=" + libelle + ", code=" + code + ", duree=" + duree + ", outils="
				+ outils + ", modules=" + modules + "]";
	}


	
	
	

}
