package sopramon.model;


import java.util.Date;

public class Combat {

	private int id;
	private Date date;
	private Arene arene;
	private Type type;
	private int tours;
	private int sopramon;
	private int boss;
	private ICombattant joueur1;
	private ICombattant joueur2;
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public ICombattant getJoueur1() {
		return joueur1;
	}
	public void setJoueur1(ICombattant joueur1) {
		this.joueur1 = joueur1;
	}
	public ICombattant getJoueur2() {
		return joueur2;
	}
	public void setJoueur2(ICombattant joueur2) {
		this.joueur2 = joueur2;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Arene getArene() {
		return arene;
	}
	public void setArene(Arene arene) {
		this.arene = arene;
	}
	public Type getType() {
		return type;
	}
	public void setType(Type type) {
		this.type = type;
	}
	public int getTours() {
		return tours;
	}
	public void setTours(int tours) {
		this.tours = tours;
	}
	
	
	
	 public int getSopramon() {
		return sopramon;
	}
	public void setSopramon(int sopramon) {
		this.sopramon = sopramon;
	}
	public int getBoss() {
		return boss;
	}
	public void setBoss(int boss) {
		this.boss = boss;
	}
	public void duel() {
		 
	 }
	

}
