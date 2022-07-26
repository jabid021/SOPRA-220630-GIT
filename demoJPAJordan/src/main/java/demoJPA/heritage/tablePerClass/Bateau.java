package demoJPA.heritage.tablePerClass;

import javax.persistence.Entity;
import javax.persistence.Table;

//@Entity
@Table(name="ship")
public class Bateau extends Vehicule {

	public Bateau() {
	}

	@Override
	public String toString() {
		return "Bateau [id=" + id + ", roues=" + roues + "]";
	}
	
	
	
}
