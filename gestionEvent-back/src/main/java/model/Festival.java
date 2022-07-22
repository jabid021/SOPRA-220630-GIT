package model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Festival extends Evenement {
	
	private List<Prestation> prestations = new ArrayList();
	
	public Festival(String libelle, LocalDate dateDebut,LocalTime heureDebut, LocalDate dateFin, LocalTime heureFin,
			double prix,Adresse adresse) {
		super(libelle,dateDebut,dateFin,heureDebut,heureFin,prix,adresse);
	}
	
	public Festival(Integer id,String libelle, LocalDate dateDebut,LocalTime heureDebut, LocalDate dateFin, LocalTime heureFin,
			double prix,Adresse adresse) {
		super(id,libelle,dateDebut,dateFin,heureDebut,heureFin,prix,adresse);
	}

	public List<Prestation> getPrestations() {
		return prestations;
	}

	public void setPrestations(List<Prestation> prestations) {
		this.prestations = prestations;
	}
	
	

	@Override
	public String toString() {
		return "Festival [id="+id+",libelle=" + libelle + ", dateDebut=" + dateDebut + ", dateFin=" + dateFin + ", heureDebut="
				+ heureDebut + ", heureFin=" + heureFin + ", prix=" + prix + ", spectateurs=" + spectateurs
				+ ", adresse=" + adresse + ", prestations=" + prestations + "]";
	}

	
	
	
	
}
