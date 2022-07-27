package model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity

public class Secretaire extends Compte {

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
