package demoJPA.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.UniqueConstraint;

@Entity
@DiscriminatorValue("form")
public class Formateur extends Personne{
	
	//joinColumns = id maitre = id de la classe actuelle = Formateur
	//inverseJoinColumns = id esclave = id du type de la liste = Matiere
	@ManyToMany
	@JoinTable(
			name = "formations",
			joinColumns =@JoinColumn(name="formateur") ,
			inverseJoinColumns = @JoinColumn(name="matiere"),
			uniqueConstraints = @UniqueConstraint(columnNames = {"formateur","matiere"})
			)
	private List<Matiere> matieres=new ArrayList();

	public Formateur() {}
	
	public Formateur(String login, String password, String nom, String prenom, int taille, LocalDate naissance,
			double salaire, boolean permis, Civilite civ, Adresse adresse) {
		super(login, password, nom, prenom, taille, naissance, salaire, permis, civ, adresse);
	}

	public List<Matiere> getMatieres() {
		return matieres;
	}

	public void setMatieres(List<Matiere> matieres) {
		this.matieres = matieres;
	}

	@Override
	public String toString() {
		return "Formateur [matieres=" + matieres + ", id=" + id + ", login=" + login + ", password=" + password
				+ ", nom=" + nom + ", prenom=" + prenom + ", taille=" + taille + ", naissance=" + naissance
				+ ", salaire=" + salaire + ", permis=" + permis + ", civ=" + civ + ", adresse=" + adresse + "]";
	}

	
	
	

}
