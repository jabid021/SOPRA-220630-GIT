package demoJPA.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Ordinateur {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String marque;
	private String os;
	
	
	public Ordinateur() {
	}


	public Ordinateur(String marque, String os) {
		this.marque = marque;
		this.os = os;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getMarque() {
		return marque;
	}


	public void setMarque(String marque) {
		this.marque = marque;
	}


	public String getOs() {
		return os;
	}


	public void setOs(String os) {
		this.os = os;
	}


	@Override
	public String toString() {
		return "Ordinateur [id=" + id + ", marque=" + marque + ", os=" + os + "]";
	}

	
}
