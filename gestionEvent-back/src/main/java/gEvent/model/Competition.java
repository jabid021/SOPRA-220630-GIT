package gEvent.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Competition extends Evenement {
	
	private User gagnant;
	
	//mappedBy
	private List<Participation> participants;
	
	private Sport sport;
	
	
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


	

	

	
	
	
}
