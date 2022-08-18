package eshop.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import com.fasterxml.jackson.annotation.JsonView;

import eshop.model.jsonview.JsonViews;

@Embeddable
public class Adresse {
	@JsonView(JsonViews.Base.class)
	@Column(name = "number", length = 8)
	private String numero;
	@JsonView(JsonViews.Base.class)
	@Column(name = "street", length = 35)
	private String voie;
	@JsonView(JsonViews.Base.class)
	@Column(name = "pc", length = 12)
	private String cp;
	@JsonView(JsonViews.Base.class)
	@Column(name = "city", length = 50)
	private String ville;

	public Adresse() {
	}

	public Adresse(String numero, String voie, String cp, String ville) {
		this.numero = numero;
		this.voie = voie;
		this.cp = cp;
		this.ville = ville;
	}

	@Override
	public String toString() {
		return "Adresse [numero=" + numero + ", voie=" + voie + ", cp=" + cp + ", ville=" + ville + "]";
	}

	public String getAdresse() {
		return numero + " " + voie + "\n" + cp + " " + ville;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getVoie() {
		return voie;
	}

	public void setVoie(String voie) {
		this.voie = voie;
	}

	public String getCp() {
		return cp;
	}

	public void setCp(String cp) {
		this.cp = cp;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

}
