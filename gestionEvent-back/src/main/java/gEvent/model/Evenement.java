package gEvent.model;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Evenement {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	protected Integer id;
	protected String libelle;
	@Column(name = "date_debut")
	protected LocalDate dateDebut;
	@Column(name= "date_fin")
	protected LocalDate dateFin;
	@Column(name="heure_debut")
	protected LocalTime heureDebut;
	@Column(name="heure_fin")
	protected LocalTime heureFin;
	protected double prix;
	
	
	//mappedBy
	@OneToMany(mappedBy = "evenement")
	protected List<Spectateur> spectateurs = new ArrayList();
	
	@Embedded
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

	
	public Evenement() {
		// TODO Auto-generated constructor stub
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

	public List<Spectateur> getSpectateurs() {
		return spectateurs;
	}

	public void setSpectateurs(List<Spectateur> spectateurs) {
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
