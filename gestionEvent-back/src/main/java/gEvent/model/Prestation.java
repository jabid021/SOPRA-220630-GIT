package gEvent.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Prestation {
	 
private Integer id;
private LocalDate dateDebut;
private LocalDate dateFin;
private LocalTime heureDebut;
private LocalTime heureFin;
private Intervenant intervenant;
private Festival festival; 

public Prestation(LocalDate dateDebut,  LocalTime heureDebut, LocalDate dateFin,LocalTime heureFin,
			Intervenant intervenant,Festival festival) {
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.heureDebut = heureDebut;
		this.heureFin = heureFin;
		this.intervenant = intervenant;
		this.festival=festival;
	}



	public LocalDate getDateDebut() {
		return dateDebut;
	}
	
	public void setDateDebut(LocalDate dateDebut) {
		this.dateDebut = dateDebut;
	}
	
	public LocalDate getDateFin() {
		return dateFin;
	}
	
	public void setDateFin(LocalDate dateFin) {
		this.dateFin = dateFin;
	}
	
	public LocalTime getHeureDebut() {
		return heureDebut;
	}
	
	public void setHeureDebut(LocalTime heureDebut) {
		this.heureDebut = heureDebut;
	}
	
	public LocalTime getHeureFin() {
		return heureFin;
	}
	
	public void setHeureFin(LocalTime heureFin) {
		this.heureFin = heureFin;
	}


	public Intervenant getIntervenant() {
		return intervenant;
	}


	public void setIntervenant(Intervenant intervenant) {
		this.intervenant = intervenant;
	}

	

	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}

	

	public Festival getFestival() {
		return festival;
	}


	public void setFestival(Festival festival) {
		this.festival = festival;
	}


	
	
}


