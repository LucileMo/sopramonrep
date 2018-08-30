package sopramon.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;

@Entity

public class Achat {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ACH_ID")
	private int id;
	@Column(name="ACH_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date date;
	@Column(name="ACH_PRIX", nullable=false)
	@Positive
	private Double prix;
	@ManyToOne
	@JoinColumn(name="ITEM_ID")
	private Item item;
	@ManyToOne
	@JoinColumn(name="SOP_ID")
	private Sopramon sopramon;
	@Column(name="ACH_QUANTITE")
	@PositiveOrZero
	private int Quantite;
	

	public Sopramon getSopramon() {
		return sopramon;
	}
	public void setSopramon(Sopramon sopramon) {
		this.sopramon = sopramon;
	}
	public int getQuantite() {
		return Quantite;
	}
	public void setQuantite(int quantite) {
		Quantite = quantite;
	}
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
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
