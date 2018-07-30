package sopramon.model;




public enum Arene {
		
		versus(1),
		donjon(2);
	
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
		Arene(int valeur) {
		this.valeur = valeur;
		}
		public int getValeur() {
		return this.valeur;
		}
		}
	
