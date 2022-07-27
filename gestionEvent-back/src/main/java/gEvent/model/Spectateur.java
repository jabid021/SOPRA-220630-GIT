package gEvent.model;

public class Spectateur {

	private Integer id;
	private User user;
	private Evenement evenement;
	
	
	public Spectateur(User user, Evenement evenement) {
		this.user = user;
		this.evenement = evenement;
	}
	
	
	
}
