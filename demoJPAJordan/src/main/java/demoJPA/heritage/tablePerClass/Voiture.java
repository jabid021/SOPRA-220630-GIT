package demoJPA.heritage.tablePerClass;

import javax.persistence.Entity;
import javax.persistence.Table;

//@Entity
@Table(name="car")
public class Voiture extends Vehicule {

	private String marque;
	
	
	public Voiture() {
	}


	public Voiture(int roues, String marque) {
		super(roues);
		this.marque = marque;
	}


	public String getMarque() {
		return marque;
	}


	public void setMarque(String marque) {
		this.marque = marque;
	}


	@Override
	public String toString() {
		return "Voiture [id=" + id + ", roues=" + roues + ", marque=" + marque + "]";
	}
	
	
}
