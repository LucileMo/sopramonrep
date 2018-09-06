package sopramon.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

@Entity

public class Item {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name="ITEM_ID")	
private int id;
@Column(name="ITEM_NOM")
@NotEmpty
@Size(max=45)
private String nom;
@Column(name="ITEM_PRIX", nullable=false)
@Positive
private float prix;

public float getPrix() {
	return prix;
}

public void setPrix(float prix) {
	this.prix = prix;
}

@ManyToOne(cascade={ CascadeType.PERSIST, CascadeType.MERGE })
@JoinColumn(name="ITEM_CAPACITE_ID")
private Capacite capacite;
@OneToMany(mappedBy="item")
private List<Achat> achats;
@Column(name="ITEM_STOCK")
@PositiveOrZero

private int stock;

public int getStock() {
	return stock;
}
public void setStock(int stock) {
	this.stock = stock;
}
public List<Achat> getAchats() {
	return achats;
}
public void setAchats(List<Achat> achats) {
	this.achats = achats;
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


public Capacite getCapacite() {
	return capacite;
}
public void setCapacite(Capacite capacite) {
	this.capacite = capacite;
}


}
