package demoJPA.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("stag")
public class Stagiaire extends Personne{

	@Column(name="numero_ordi")
	private int numeroOrdi;
	
	@Column(name="marque_ordi", length = 25)
	private String marqueOrdi;

	public Stagiaire() {}
	
	public Stagiaire(String login, String password, String nom, String prenom, int taille, LocalDate naissance,
			double salaire, boolean permis, Civilite civ, Adresse adresse, int numeroOrdi, String marqueOrdi) {
		super(login, password, nom, prenom, taille, naissance, salaire, permis, civ, adresse);
		this.numeroOrdi = numeroOrdi;
		this.marqueOrdi = marqueOrdi;
	}


	public int getNumeroOrdi() {
		return numeroOrdi;
	}


	public void setNumeroOrdi(int numeroOrdi) {
		this.numeroOrdi = numeroOrdi;
	}


	public String getMarqueOrdi() {
		return marqueOrdi;
	}


	public void setMarqueOrdi(String marqueOrdi) {
		this.marqueOrdi = marqueOrdi;
	}


	@Override
	public String toString() {
		return "Stagiaire [id=" + id + ", login=" + login + ", password=" + password + ", nom=" + nom + ", prenom="
				+ prenom + ", taille=" + taille + ", naissance=" + naissance + ", salaire=" + salaire + ", permis="
				+ permis + ", civ=" + civ + ", adresse=" + adresse + ", numeroOrdi=" + numeroOrdi + ", marqueOrdi="
				+ marqueOrdi + "]";
	}


	

	
	
	
}
