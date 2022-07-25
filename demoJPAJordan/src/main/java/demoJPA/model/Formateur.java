package demoJPA.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("form")
public class Formateur extends Personne{
	
	@Column(length = 20)
	private String matiere;

	public Formateur() {}
	
	public Formateur(String login, String password, String nom, String prenom, int taille, LocalDate naissance,
			double salaire, boolean permis, Civilite civ, Adresse adresse, String matiere) {
		super(login, password, nom, prenom, taille, naissance, salaire, permis, civ, adresse);
		this.matiere = matiere;
	}

	public String getMatiere() {
		return matiere;
	}

	public void setMatiere(String matiere) {
		this.matiere = matiere;
	}

	@Override
	public String toString() {
		return "Formateur [id=" + id + ", login=" + login + ", password=" + password + ", nom=" + nom + ", prenom="
				+ prenom + ", taille=" + taille + ", naissance=" + naissance + ", salaire=" + salaire + ", permis="
				+ permis + ", civ=" + civ + ", adresse=" + adresse + ", matiere=" + matiere + "]";
	}
	
	

}
