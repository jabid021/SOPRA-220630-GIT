package demoJPA.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
@DiscriminatorValue("stag")
public class Stagiaire extends Personne{



	//X=> nombre de stagiaire que peut avoir un ordinateur
	//Y => nombre d'ordinateur que peut avoir un stagiaire
	
	@OneToOne
	@JoinColumn(name="id_ordinateur",unique = true)
	private  Ordinateur ordinateur;
	
	
	@ManyToOne
	@JoinColumn(name="id_matiere")
	private Matiere matiere;

	public Stagiaire() {}
	
	public Stagiaire(String login, String password, String nom, String prenom, int taille, LocalDate naissance,
			double salaire, boolean permis, Civilite civ, Adresse adresse) {
		super(login, password, nom, prenom, taille, naissance, salaire, permis, civ, adresse);
	}

	

	public Ordinateur getOrdinateur() {
		return ordinateur;
	}

	public void setOrdinateur(Ordinateur ordinateur) {
		this.ordinateur = ordinateur;
	}

	
	public Matiere getMatiere() {
		return matiere;
	}

	public void setMatiere(Matiere matiere) {
		this.matiere = matiere;
	}

	@Override
	public String toString() {
		return "Stagiaire [id=" + id + ", login=" + login + ", password=" + password + ", nom=" + nom + ", prenom="
				+ prenom + ", taille=" + taille + ", naissance=" + naissance + ", salaire=" + salaire + ", permis="
				+ permis + ", civ=" + civ + ", adresse=" + adresse + ", ordinateur=" + ordinateur + ", matiere=" + matiere + "]";
	}

	

	


	

	
	
	
}
