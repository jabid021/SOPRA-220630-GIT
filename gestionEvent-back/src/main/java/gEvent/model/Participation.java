package gEvent.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Participation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@OneToMany
	private User user;

	@OneToMany
	private Competition competion;

	public Participation() {

	}

	public Participation(User user, Competition competion) {
		this.user = user;
		this.competion = competion;
	}

	public Integer getId() {
		return id;
	}

	public User getUser() {
		return user;
	}

	public Competition getCompetion() {
		return competion;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setCompetion(Competition competion) {
		this.competion = competion;
	}

	@Override
	public String toString() {
		return "Participation [id=" + id + ", user=" + user + ", competion=" + competion + "]";
	}

	
	
	
}
