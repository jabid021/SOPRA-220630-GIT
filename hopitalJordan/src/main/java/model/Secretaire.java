package model;

<<<<<<< HEAD
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity

=======
import javax.persistence.Entity;

@Entity
>>>>>>> groupe2
public class Secretaire extends Compte {

	public Secretaire() {
	}
	public Secretaire(String login) {
		super(login);
	}

	public Secretaire() {
		
	}

	
	@Override
	public String toString() {
		return "Secretaire [id=" + id + ", login=" + login + ", password=" + password + "]";
	}

	
	
}
