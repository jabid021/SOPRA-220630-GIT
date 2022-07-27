package gEvent.model;
import java.time.LocalDate;
import java.util.List;

public class User extends Compte{
	
	private String nom;
	private String prenom;
	private LocalDate naissance;
	private String telephone;
	private Adresse adresse;
	
	//mappedBy
	private List<Participation> participations;
	
	//mappedBy
	private List<Spectateur> spectateurs;
	
	//mappedBy
	private List<Competition> gagnants;
	
	

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