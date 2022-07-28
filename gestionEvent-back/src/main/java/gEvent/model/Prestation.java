package gEvent.model;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Version;

@Entity
public class Prestation {
	 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="date_debut")
	private LocalDate dateDebut;
	@Column(name="date_fin")
	private LocalDate dateFin;
	@Column(name="heure_debut")
	private LocalTime heureDebut;
	@Column(name="heure_fin")
	private LocalTime heureFin;
	
	@OneToOne
	@JoinColumn(name="id_intervenant")
	private Intervenant intervenant;
	
	@ManyToOne
	@JoinColumn(name="id_festival")
	private Festival festival; 
	
	
	@Version
	private int version;
	
	public Prestation() {
		
	}
	
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

	
	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	@Override
	public String toString() {
		return "Prestation [id=" + id + ", dateDebut=" + dateDebut + ", dateFin=" + dateFin + ", heureDebut="
				+ heureDebut + ", heureFin=" + heureFin + ", intervenant=" + intervenant + "]";
	}


	
	
}


