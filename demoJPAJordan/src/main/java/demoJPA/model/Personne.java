package demoJPA.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//OBLIGATOIRE
@Entity
public class Personne {
	
	//OBLIGATOIRE
	@Id
	//SEMI-OBLIGATOIRE pour gerer en auto-increment**
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	
	private String login;
	private String password;
	private String nom;
	private String prenom;
	private int taille;
	private LocalDate naissance;
	private double salaire;
	
	private boolean permis;

	private Civilite civ;
	private transient Adresse adresse;
	
	
	//Constructeur vide OBLIGATOIRE + Tous les GETTERS / SETTERS
	public Personne() {
	}
	
	public Personne(String login, String password, String nom, String prenom, int taille, LocalDate naissance,
			double salaire, boolean permis, Civilite civ, Adresse adresse) {
		this.login = login;
		this.password = password;
		this.nom = nom;
		this.prenom = prenom;
		this.taille = taille;
		this.naissance = naissance;
		this.salaire = salaire;
		this.permis = permis;
		this.civ = civ;
		this.adresse = adresse;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public int getTaille() {
		return taille;
	}

	public void setTaille(int taille) {
		this.taille = taille;
	}

	public LocalDate getNaissance() {
		return naissance;
	}

	public void setNaissance(LocalDate naissance) {
		this.naissance = naissance;
	}

	public double getSalaire() {
		return salaire;
	}

	public void setSalaire(double salaire) {
		this.salaire = salaire;
	}

	public boolean isPermis() {
		return permis;
	}

	
	public void setPermis(boolean permis) {
		this.permis = permis;
	}
	
	

	public Civilite getCiv() {
		return civ;
	}

	public void setCiv(Civilite civ) {
		this.civ = civ;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Personne [id=" + id + ", login=" + login + ", password=" + password + ", nom=" + nom + ", prenom="
				+ prenom + ", taille=" + taille + ", naissance=" + naissance + ", salaire=" + salaire + ", permis="
				+ permis + ", civ=" + civ + ", adresse=" + adresse + "]";
	}

	


	
	
	
	

}
