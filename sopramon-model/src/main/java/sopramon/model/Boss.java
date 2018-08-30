package sopramon.model;

import java.util.List;


import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "boss")

public class Boss implements ICombattant {

	// CLE PRIMAIRE
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "BOSS_ID")
	public int id;

	@Column(name = "BOSS_NOM", length = 45, nullable = false)
	@NotEmpty
	@Size(max = 45)
	public String nom;

	@Column(name = "BOSS_NIVEAU", length = 50, nullable = false)
	@NotEmpty
	@Size(max = 50)
	public int niveau;

	// CLE ETRANGERE
	@OneToOne
	@JoinColumn(name = "BOSS_CAPACITE_ID")
	private Capacite capacite;

	// CLE ETRANGERE
	@OneToMany(mappedBy = "boss")
	private List<Combat> combats;
	
	
	//lien signe
	@OneToOne
	@JoinColumn(name = "BOSS_SIGNE")
	public Signe signe;
	
	public Signe getSigne() {
		return signe;
	}

	public void setSigne(Signe signe) {
		this.signe = signe;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}



	public List<Combat> getCombats() {
		return combats;
	}

	public void setCombats(List<Combat> combats) {
		this.combats = combats;
	}

	public int getNiveau() {
		return niveau;
	}

	public void setNiveau(int niveau) {
		this.niveau = niveau;
	}

	public Capacite getCapacite() {
		return capacite;
	}

	public void setCapacite(Capacite capacite) {
		this.capacite = capacite;
	}

	public void attaquer() {
		// TODO Auto-generated method stub

	}
}
