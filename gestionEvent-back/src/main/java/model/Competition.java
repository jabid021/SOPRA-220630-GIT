package model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Competition extends Evenement {
	
	private User gagnant;
	private List<User> participants = new ArrayList();
	private Sport sport;
	
	
	public Competition(String libelle, LocalDate dateDebut,  LocalTime heureDebut,LocalDate dateFin, LocalTime heureFin,
			double prix, Sport sport, Adresse adresse) {
		super(libelle,dateDebut,dateFin,heureDebut,heureFin,prix,adresse);
		this.sport = sport;
	}

	public Competition(Integer id,String libelle, LocalDate dateDebut,  LocalTime heureDebut,LocalDate dateFin, LocalTime heureFin,
			double prix, Sport sport, Adresse adresse) {
		super(id,libelle,dateDebut,dateFin,heureDebut,heureFin,prix,adresse);
		this.sport = sport;
	}

	public User getGagnant() {
		return gagnant;
	}


	public void setGagnant(User gagnant) {
		this.gagnant = gagnant;
	}


	public List<User> getParticipants() {
		return participants;
	}


	public void setParticipants(List<User> participants) {
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
		return "Competition [id="+id+",libelle=" + libelle + ", dateDebut=" + dateDebut + ", dateFin=" + dateFin + ", heureDebut="
				+ heureDebut + ", heureFin=" + heureFin + ", prix=" + prix + ", spectateurs=" + spectateurs
				+ ", adresse=" + adresse + ", gagnant=" + gagnant + ", participants=" + participants + ", sport="
				+ sport + "]";
	}


	

	
	
	
}
