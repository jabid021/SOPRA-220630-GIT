package eshop.model;

import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.data.web.JsonPath;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;

import eshop.model.jsonview.Base;
import eshop.model.jsonview.JsonViews;
import eshop.model.jsonview.ProduitWithFournisseur;

@Entity
@Table(name = "product")
public class Produit {

	@JsonView(JsonViews.Base.class)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@JsonView(JsonViews.Base.class)
	@NotEmpty
	@Size(max = 20)
	// @Pattern
	@Column(name = "label", length = 20, nullable = false)
	private String libelle;

	@JsonView(JsonViews.Base.class)
	@Min(value = 0, message = "message sur min")
	@Column(name = "price", nullable = false)
	private double prix;

	@JsonView({ JsonViews.ProduitWithFournisseur.class, JsonViews.ProduitWithAchatsAndFournisseur.class })
	@ManyToOne
	@JoinColumn(name = "vendeur")
	private Fournisseur fournisseur;

	@JsonView({ JsonViews.ProduitWithAchats.class, JsonViews.ProduitWithAchatsAndFournisseur.class })
	@OneToMany(mappedBy = "produit", fetch = FetchType.LAZY)
	private List<Achat> achats;

	@Version
	private int version;

	public Produit() {
	}

	public Produit(String libelle, double prix, Fournisseur fournisseur) {
		this.libelle = libelle;
		this.fournisseur = fournisseur;
		this.prix = prix;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public Fournisseur getFournisseur() {
		return fournisseur;
	}

	public void setFournisseur(Fournisseur fournisseur) {
		this.fournisseur = fournisseur;
	}

	public List<Achat> getAchats() {
		return achats;
	}

	public void setAchats(List<Achat> achats) {
		this.achats = achats;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	@Override
	public String toString() {
		return "Produit [id=" + id + ", libelle=" + libelle + ", prix=" + prix + ", fournisseur=" + fournisseur + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produit other = (Produit) obj;
		return Objects.equals(id, other.id);
	}

}
