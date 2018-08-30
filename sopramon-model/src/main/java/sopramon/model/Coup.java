package sopramon.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "coup")

public class Coup {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "COUP_ID")
	private int coupid;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="COUP_DATE")
	private Date date;

	@Column(name = "COUP_DEGATS", length = 50, nullable = false)
	@NotEmpty
	@Size(max = 50)
	private int degats;

	@Column(name = "COUP_PERSISTANCE", length = 50, nullable = false)
	@NotEmpty
	@Size(max = 50)
	private int peristance;

	// CLE ETRANGERE
	@ManyToOne
	@JoinColumn(name = "COUP_SOPRAMON_ID")
	private Sopramon sopramonid;

	// CLE ETRANGERE
	@ManyToOne
	@JoinColumn(name = "COUP_COMBAT_ID")
	private Combat combat;
	

	public void setDate(Date date) {
		this.date = date;
	}

	public int getDegats() {
		return degats;
	}

	public void setDegats(int degats) {
		this.degats = degats;
	}

	public int getCoupid() {
		return coupid;
	}

	public void setCoupid(int coupid) {
		this.coupid = coupid;
	}

	public int getPeristance() {
		return peristance;
	}

	public void setPeristance(int peristance) {
		this.peristance = peristance;
	}

	public Sopramon getSopramonid() {
		return sopramonid;
	}

	public void setSopramonid(Sopramon sopramonid) {
		this.sopramonid = sopramonid;
	}

	public Combat getCombat() {
		return combat;
	}

	public void setCombat(Combat combat) {
		this.combat = combat;
	}

	public Date getDate() {
		return date;
	}

}
