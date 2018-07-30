package sopramon.model;


public class Signe{
	
	
	private int id;
	private String nom;
	private Type type;
	private String typeNom;
	private Signe faiblesse;
	private Signe avantage;
	
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
	public Signe getFaiblesse() {
		return faiblesse;
	}
	public void setFaiblesse(Signe faiblesse) {
		this.faiblesse = faiblesse;
	}
	public Signe getAvantage() {
		return avantage;
	}
	public void setAvantage(Signe avantage) {
		this.avantage = avantage;
	}
	

}
