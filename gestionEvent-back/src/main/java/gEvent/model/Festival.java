package gEvent.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Festival extends Evenement {
	
	//mappedBy
	private List<Prestation> prestations;
	
	public Festival(String libelle, LocalDate dateDebut,LocalTime heureDebut, LocalDate dateFin, LocalTime heureFin,
			double prix,Adresse adresse) {
		super(libelle,dateDebut,dateFin,heureDebut,heureFin,prix,adresse);
	}
	
	
	public List<Prestation> getPrestations() {
		return prestations;
	}

	public void setPrestations(List<Prestation> prestations) {
		this.prestations = prestations;
	}
	
	

	

	
	
	
	
}
