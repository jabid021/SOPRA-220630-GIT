package model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="visite")
public class Visite {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="numero")
	private int id;
	
	
	@ManyToOne
	@JoinColumn(name="id_medecin",nullable = false)
	private Medecin medecin;
	@ManyToOne
	@JoinColumn(name="id_patient",nullable = false)
	private Patient patient;
	@Column(name="date_visite",nullable = false)
	private LocalDate dateVisite;
	private double prix=20;
	private int salle;
	
	
	public Visite() {}
	
	public Visite(int id, Medecin medecin, Patient patient, String dateVisite, double prix, int salle) {
		this.id = id;
		this.medecin = medecin;
		this.patient = patient;
		this.dateVisite = LocalDate.parse(dateVisite);
		this.prix = prix;
		this.salle = salle;
	}
	
	
	
	public Visite(Medecin medecin, Patient patient) {
		this.medecin = medecin;
		this.patient = patient;
		this.dateVisite = LocalDate.now();
		this.salle = medecin.getSalle();
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public Medecin getMedecin() {
		return medecin;
	}



	public void setMedecin(Medecin medecin) {
		this.medecin = medecin;
	}



	public Patient getPatient() {
		return patient;
	}



	public void setPatient(Patient patient) {
		this.patient = patient;
	}



	public LocalDate getDateVisite() {
		return dateVisite;
	}



	public void setDateVisite(String dateVisite) {
		this.dateVisite = LocalDate.parse(dateVisite);
	}



	public double getPrix() {
		return prix;
	}



	public void setPrix(double prix) {
		this.prix = prix;
	}



	public int getSalle() {
		return salle;
	}



	public void setSalle(int salle) {
		this.salle = salle;
	}



	@Override
	public String toString() {
		return "Visite [id=" + id + ", medecin=" + medecin.login + ", patient=" + patient + ", dateVisite=" + dateVisite
				+ ", prix=" + prix + ", salle=" + salle + "]";
	}
	
	
	
	
	

}
