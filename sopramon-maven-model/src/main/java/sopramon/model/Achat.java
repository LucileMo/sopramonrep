package sopramon.model;


import java.util.Date;

public class Achat {
	private int id;
	private Date date;
	private Double prix;
	
	public Date getDate() {
		return date;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Double getPrix() {
		return prix;
	}
	public void setPrix(Double prix) {
		this.prix = prix;
	}
	

}
