package demoJPA.heritage.joined;

import javax.persistence.Entity;

//@Entity
public class Lion extends Animal {

	public Lion() {
	}

	public Lion(String couleur) {
		super(couleur);
	}

	@Override
	public String toString() {
		return "Lion [id=" + id + ", couleur=" + couleur + "]";
	}

	
	
	
	
}
