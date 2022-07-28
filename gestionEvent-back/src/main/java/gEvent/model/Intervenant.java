package gEvent.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

@Entity
public class Intervenant {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nom ;
	
	/*@JoinTable(
			name = "talents")
	@ElementCollection(fetch = FetchType.EAGER)	
	@Enumerated(EnumType.STRING)*/
	
	@ElementCollection(targetClass = Talent.class)
	@JoinTable(name = "talents", joinColumns = @JoinColumn(name = "intervenant"))
	@Column(name = "talent", nullable = false,columnDefinition = "ENUM('Chant','Danse','Mixer','Autre')")
	@Enumerated(EnumType.STRING)
	private List<Talent> talents = new ArrayList();
	
	@OneToMany(mappedBy = "intervenant")
	private List<Prestation> prestations;

	public Intervenant() {}
	
	public Intervenant(String nom) {
		this.nom = nom;
	}
	
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}

	

	public List<Talent> getTalents() {
		return talents;
	}


	public void setTalents(List<Talent> talents) {
		this.talents = talents;
	}

	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}

	
	public List<Prestation> getPrestations() {
		return prestations;
	}

	public void setPrestations(List<Prestation> prestations) {
		this.prestations = prestations;
	}

	@Override
	public String toString() {
		return "Intervenant [id=" + id + ", nom=" + nom + "]";
	}

	


}