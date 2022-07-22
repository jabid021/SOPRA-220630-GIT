package model;
import java.time.LocalDate;

public class User extends Compte{
	
	private String nom;
	private String prenom;
	private LocalDate naissance;
	private String telephone;
	private Adresse adresse;

	public User(String login, String password, String nom, String prenom, LocalDate naissance, String telephone, Adresse adresse) {
		super(login, password);
		this.adresse= adresse;
		this.nom = nom;
		this.prenom = prenom;
		this.naissance = naissance;
		this.telephone = telephone;
	}
	
	
	
	public User(Integer id, String login, String password, String nom, String prenom, LocalDate naissance,
			String telephone, Adresse adresse) {
		super(id, login, password);
		this.nom = nom;
		this.prenom = prenom;
		this.naissance = naissance;
		this.telephone = telephone;
		this.adresse = adresse;
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
	@Override
	public String toString() {
		return "User [id="+id+",login=" + login + ", password=" + password + ", nom=" + nom + ", prenom=" + prenom
				+ ", naissance=" + naissance + ", telephone=" + telephone + ", adresse=" + adresse + "]";
	}
	
	
}