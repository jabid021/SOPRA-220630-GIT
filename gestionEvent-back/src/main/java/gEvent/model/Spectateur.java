package gEvent.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Spectateur {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne
	private User user;
	
	@OneToOne
	private Evenement evenement;
	
	
	public Spectateur() {}
	
	public Spectateur(User user, Evenement evenement) {
		this.user = user;
		this.evenement = evenement;
	}
	
	
	
}
