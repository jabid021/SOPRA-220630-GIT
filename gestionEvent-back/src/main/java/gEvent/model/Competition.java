package gEvent.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
@Entity
@DiscriminatorValue("competition")
public class Competition extends Evenement {
	
	@ManyToOne
	@JoinColumn(name="gagnant")
	private User gagnant;
	
	@OneToMany(mappedBy = "competition")
	private List<Participation> participants;
	
	@Enumerated(EnumType.STRING)
	@Column(columnDefinition = "ENUM('Judo', 'Foot', 'LoL', 'Ski', 'BierrePong')")
	private Sport sport;
	
	public Competition() {
		// TODO Auto-generated constructor stub
	}
	
	public Competition(String libelle, LocalDate dateDebut,  LocalTime heureDebut,LocalDate dateFin, LocalTime heureFin,
			double prix, Sport sport, Adresse adresse) {
		super(libelle,dateDebut,dateFin,heureDebut,heureFin,prix,adresse);
		this.sport = sport;
	}

	public User getGagnant() {
		return gagnant;
	}


	public void setGagnant(User gagnant) {
		this.gagnant = gagnant;
	}


	public List<Participation> getParticipants() {
		return participants;
	}


	public void setParticipants(List<Participation> participants) {
		this.participants = participants;
	}


	public Sport getSport() {
		return sport;
	}


	public void setSport(Sport sport) {
		this.sport = sport;
	}

	@Override
	public String toString() {
		return "Competition [id=" + id + ", libelle=" + libelle + ", dateDebut=" + dateDebut + ", dateFin=" + dateFin
				+ ", heureDebut=" + heureDebut + ", heureFin=" + heureFin + ", prix=" + prix + ", adresse=" + adresse
				+ ", gagnant=" + gagnant + ", sport=" + sport + "]";
	}


	

	

	
	
	
}
