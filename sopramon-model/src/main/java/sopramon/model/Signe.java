package sopramon.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity

public class Signe{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "SIG_ID")
	private int id;
	@Column(name = "SIG_NOM", length = 45, nullable = false)
	@NotEmpty
	@Size(max = 45)
	private String nom;
	@Column(name="SIG_TYPE")
	@Enumerated(EnumType.ORDINAL)
	@NotEmpty
	private Type type;
	@Column(name = "SIG_TYPE_NOM", length = 45, nullable = false)
	@NotEmpty
	@Size(max = 45)
	
	private String typeNom;
	
	
	public String getTypeNom() {
		return typeNom;
	}
	public void setTypeNom(String typeNom) {
		this.typeNom = typeNom;
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
	
	public Type getType() {
		return type;
	}
	public void setType(Type type) {
		this.type = type;
	}

	

}
