package orchestre.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Personne {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String prenom;
	
	private String login;
	private String password;
	
	
	
	public Personne() {
	}
	

	public Personne(String prenom) {
		this.prenom = prenom;
	}

	
	public Personne(String prenom, String login, String password) {
		this.prenom = prenom;
		this.login = login;
		this.password = password;
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
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

	@Override
	public String toString() {
		return "Personne [id=" + id + ", prenom=" + prenom + ", login=" + login + ", password=" + password + "]";
	}
	
	
	
}
