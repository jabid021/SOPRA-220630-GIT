package eshop.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue("supplier")
public class Fournisseur extends Personne {

	@Column(name="company",length = 25)
	private String societe;
	
	@OneToMany(mappedBy = "fournisseur")
	private List<Produit> produits;
	
	public Fournisseur() {}

	public Fournisseur(String nom, String prenom, String societe) {
		super(nom, prenom);
		this.societe = societe;
	}

	public String getSociete() {
		return societe;
	}

	public void setSociete(String societe) {
		this.societe = societe;
	}
	
	

	public List<Produit> getProduits() {
		return produits;
	}

	public void setProduits(List<Produit> produits) {
		this.produits = produits;
	}

	@Override
	public String toString() {
		return "Fournisseur [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", adresse=" + adresse + ", societe="
				+ societe + "]";
	}

	
	
	
	
	
	
}
