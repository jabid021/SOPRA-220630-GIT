package demoJPA.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

//OBLIGATOIRE
@Entity
@Table(name="person")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="type_personne")
public abstract class Personne {
	
	//OBLIGATOIRE
	@Id
	//SEMI-OBLIGATOIRE pour gerer en auto-increment**
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Integer id;
	
	//length = 25 meme chose que columnDefinition = "VARCHAR(25)"
	@Column(length = 25, nullable = false, unique = true)
	protected String login;
	
	@Column(name="mot_de_passe", columnDefinition = "VARCHAR(125)", nullable = false)
	protected String password;
	
	@Column(length = 25, nullable = false)
	protected String nom;
	
	
	@Column(columnDefinition = "VARCHAR(35) default 'John'" , nullable = false )
	protected String prenom;
	
	protected int taille;
	
	@Column(nullable = false)
	protected LocalDate naissance;
	
	//Decimal(x,y) => x = lenght, y= nombre deci
	@Column(columnDefinition = "DECIMAL(7,2)", nullable = false)
	protected double salaire;
	
	@Column(columnDefinition = "bit(1) default 0")
	protected boolean permis;
	
	//permet de stocker la valeur de l'enum et non son index 
	@Enumerated(EnumType.STRING)
	@Column(columnDefinition = "ENUM('Homme','Femme','Nb')")
	protected Civilite civ;
	
	@Embedded
	protected Adresse adresse;
	
	
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


	


	
	
	
	

}
