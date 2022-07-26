package demoJPA.heritage.joined;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

//@Entity
@Table(name="dog")
@PrimaryKeyJoinColumn(name = "id_chien")
public class Chien extends Animal{
	
	
	
	@Column(length=15,nullable = false)
	private String race;
	

	public Chien() {
	}


	public Chien(String couleur, String race) {
		super(couleur);
		this.race = race;
	}



	public String getRace() {
		return race;
	}


	public void setRace(String race) {
		this.race = race;
	}


	@Override
	public String toString() {
		return "Chien [id=" + id + ", couleur=" + couleur + ", race=" + race + "]";
	}
	
	
}
