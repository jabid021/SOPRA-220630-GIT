package model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
<<<<<<< HEAD
@DiscriminatorColumn(name="type_compte",columnDefinition = "ENUM('Medecin','Secretaire')")
=======
@DiscriminatorColumn(name="type_compte",columnDefinition = "enum('Medecin', 'Secretaire') nullable false")
@Table(name="compte")
>>>>>>> groupe2
public abstract class Compte {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected int id;
<<<<<<< HEAD
	
	@Column(length = 10, nullable = false, unique = true)
	protected String login;
	@Column(columnDefinition = "VARCHAR(15)", nullable = false)
	protected String password;
	
	
	public Compte() {
	}



=======
	@Column(length = 35,nullable = false)
	protected String login;
	@Column(length = 100,nullable = false)
	protected String password;
	
	public Compte() {
	}
	
>>>>>>> groupe2
	public Compte(String login) {
		this.login = login;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
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
	
	
	
	
}
