package sopramon.model;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)

public class Utilisateur {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "UTIL_ID")
private int id;
@Column(name="UTIL_NOM", length=15, nullable=false)
@NotEmpty
@Size(max=15)
private String nom;
@Column(name="UTIL_PRENOM", length=15, nullable=false)
@NotEmpty
@Size(max=15)
private String prenom;
@Column(name="UTIL_USERNAME", length=30, nullable=false)
@NotEmpty
@Size(max=30)
private String username;
@Column(name="UTIL_PASSWORD", length=30, nullable=false)
@NotEmpty
@Size(max=30)
private String password;



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
public String getPrenom() {
	return prenom;
}
public void setPrenom(String prenom) {
	this.prenom = prenom;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}



}
