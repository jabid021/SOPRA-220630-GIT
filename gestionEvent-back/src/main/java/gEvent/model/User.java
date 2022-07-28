package gEvent.model;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue("User")
public class User extends Compte{
	
	@Column(length = 25)
	private String nom;
	
	@Column(length = 25)
	private String prenom;
	
	private LocalDate naissance;
	
	@Column(length = 15)
	private String telephone;
	
	@Embedded
	private Adresse adresse;
	
	@OneToMany("competion")
	private List<Participation> participations;
	
	@OneToMany("evenement")
	private List<Spectateur> spectateurs;
	
	@OneToMany("gagnant")
	private List<Competition> gagnants;
	
	public User(){}

	public User(String login, String password, String nom, String prenom, LocalDate naissance, String telephone, Adresse adresse) {
		super(login, password);
		this.adresse= adresse;
		this.nom = nom;
		this.prenom = prenom;
		this.naissance = naissance;
		this.telephone = telephone;
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
	public LocalDate getNaissance() {
		return naissance;
	}
	public void setNaissance(LocalDate naissance) {
		this.naissance = naissance;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	
	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}
	
	public Adresse getAdresse() {
		return adresse;
	}
	
	
	
	
	
}