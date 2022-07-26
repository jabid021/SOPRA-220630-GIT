package demoJPA.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Matiere {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String libelle;
	private int code;
	private int duree;
	
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

	@Override
	public String toString() {
		return "Matiere [id=" + id + ", libelle=" + libelle + ", code=" + code + ", duree=" + duree + "]";
	}

	
	
	

}
