package eshop.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Adresse {

	@Column(name="number",length = 8)
	private String numero;
	
	@Column(name="street",length = 35)
	private String voie;
	
	@Column(name="pc",length = 12)
	private String cp;
	
	@Column(name="city",length = 50)
	private String ville;
	
	public Adresse() {}

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
	
	
	
	
	
}
