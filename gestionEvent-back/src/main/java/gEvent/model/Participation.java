package gEvent.model;

public class Participation {

	
	private Integer id;
	private User user;
	private Competition competion;
	
	
	public Participation(User user, Competition competion) {
		this.user = user;
		this.competion = competion;
	}
	
	
	
}
