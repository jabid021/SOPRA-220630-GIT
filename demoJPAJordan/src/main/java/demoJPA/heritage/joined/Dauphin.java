package demoJPA.heritage.joined;

import javax.persistence.Entity;

//@Entity
public class Dauphin extends Animal {

	
	private int taille;
	
	public Dauphin() {
	}

	public Dauphin(String couleur, int taille) {
		super(couleur);
		this.taille = taille;
	}

	public int getTaille() {
		return taille;
	}

	public void setTaille(int taille) {
		this.taille = taille;
	}

	@Override
	public String toString() {
		return "Dauphin [id=" + id + ", couleur=" + couleur + ", taille=" + taille + "]";
	}
	
	
}
