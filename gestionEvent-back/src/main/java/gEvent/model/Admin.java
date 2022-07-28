package gEvent.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

//

@Entity
@DiscriminatorValue("Admin")
public class Admin extends Compte {
	public Admin(String login, String password) {
		super(login, password);
	}
	public Admin() {		
	}	


}
