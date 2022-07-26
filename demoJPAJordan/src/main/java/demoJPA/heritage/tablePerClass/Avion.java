package demoJPA.heritage.tablePerClass;

import javax.persistence.Entity;
import javax.persistence.Table;

//@Entity
@Table(name="plane")
public class Avion extends Vehicule{
	
	
	private String pilote;

	public Avion() {
	}
	
	public Avion(int roues, String pilote) {
		super(roues);
		this.pilote = pilote;
	}

	public String getPilote() {
		return pilote;
	}

	public void setPilote(String pilote) {
		this.pilote = pilote;
	}

	@Override
	public String toString() {
		return "Avion [id=" + id + ", roues=" + roues + ", pilote=" + pilote + "]";
	}

	
	

}
