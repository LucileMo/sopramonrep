package sopramon.model;


import java.util.Date;

public class Sopramon extends Utilisateur implements ICombattant {
private int id;
private Date dateNaissance;
private int experience;
private int niveau;
private double argent;
private Capacite capacite;
private Signe signe;
private int utilisateur;


public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}

public Capacite getCapacite() {
	return capacite;
}
public void setCapacite(Capacite capacite) {
	this.capacite = capacite;
}
public Date getDateNaissance() {
	return dateNaissance;
}
public void setDateNaissance(Date dateNaissance) {
	this.dateNaissance = dateNaissance;
}
public int getExperience() {
	return experience;
}
public void setExperience(int experience) {
	this.experience = experience;
}
public int getNiveau() {
	return niveau;
}
public void setNiveau(int niveau) {
	this.niveau = niveau;
}
public double getArgent() {
	return argent;
}
public void setArgent(double argent) {
	this.argent = argent;
}

public Signe getSigne() {
	return signe;
}
public void setSigne(Signe signe) {
	this.signe = signe;
}
public int getUtilisateur() {
	return utilisateur;
}
public void setUtilisateur(int utilisateur) {
	this.utilisateur = utilisateur;
}
public void attaquer(){
}

}

