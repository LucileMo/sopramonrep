package sopramon.model;




public enum Type {
	
	
	
	
		feu(1),
		terre(2),
		air(3),
		eau(4);
	
	public int id;
	public String Nom;
		
		public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return Nom;
	}
	public void setNom(String nom) {
		Nom = nom;
	}
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
	