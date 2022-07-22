package model;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;


public abstract class Evenement {

	protected Integer id;
	protected String libelle;
	protected LocalDate dateDebut;	
	protected LocalDate dateFin;
	protected LocalTime heureDebut;
	protected LocalTime heureFin;
	protected double prix;
	protected List<User> spectateurs = new ArrayList();
	protected Adresse adresse;
	
	public Evenement(String libelle, LocalDate dateDebut, LocalDate dateFin, LocalTime heureDebut, LocalTime heureFin,
			double prix, Adresse adresse) {
		this.libelle = libelle;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.heureDebut = heureDebut;
		this.heureFin = heureFin;
		this.prix = prix;
		this.adresse = adresse;
	}

	
	public Evenement(Integer id,String libelle, LocalDate dateDebut, LocalDate dateFin, LocalTime heureDebut, LocalTime heureFin,
			double prix, Adresse adresse) {
		this.id=id;
		this.libelle = libelle;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.heureDebut = heureDebut;
		this.heureFin = heureFin;
		this.prix = prix;
		this.adresse = adresse;
	}
	
	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
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

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public List<User> getSpectateurs() {
		return spectateurs;
	}

	public void setSpectateurs(List<User> spectateurs) {
		this.spectateurs = spectateurs;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}	
	
	
	
}
