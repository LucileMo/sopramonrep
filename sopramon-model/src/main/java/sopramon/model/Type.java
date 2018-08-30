package sopramon.model;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;



public enum Type {
	
	
	feu(1), terre(2), air(3), eau(4);

	public void setValeur(int valeur) {
		this.valeur = valeur;
	}

	private int valeur = 0;

	Type(int valeur) {
		this.valeur = valeur;
	}

	public int getValeur() {
		return this.valeur;
	}
}
