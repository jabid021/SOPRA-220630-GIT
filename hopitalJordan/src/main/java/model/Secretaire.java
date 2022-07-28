package model;

import javax.persistence.Entity;

@Entity
public class Secretaire extends Compte {

	public Secretaire() {
	}
	public Secretaire(String login) {
		super(login);
	}

	@Override
	public String toString() {
		return "Secretaire [id=" + id + ", login=" + login + ", password=" + password + "]";
	}

	
	
}
