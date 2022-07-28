package gEvent.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.persistence.Version;

@Entity
@Table(name="participants",uniqueConstraints = @UniqueConstraint(columnNames = {"id_user","id_competition"}))
public class Participation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@ManyToOne
	@JoinColumn(name="id_user")
	private User user;

	@ManyToOne
	@JoinColumn(name="id_competition")
	private Competition competition;
	
	
	@Version
	private int version;

	public Participation() {

	}

	public Participation(User user, Competition competion) {
		this.user = user;
		this.competition = competion;
	}

	public Integer getId() {
		return id;
	}

	public User getUser() {
		return user;
	}

	public Competition getCompetition() {
		return competition;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setCompetition(Competition competition) {
		this.competition = competition;
	}
	
	

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	@Override
	public String toString() {
		return "Participation [id=" + id + ", user=" + user + ", competition=" + competition + "]";
	}

	
	
	
}
