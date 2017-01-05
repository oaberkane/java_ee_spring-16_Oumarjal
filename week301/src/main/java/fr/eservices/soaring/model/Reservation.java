package fr.eservices.soaring.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class Reservation implements Serializable {
	
	
	private Integer nbPersonnes;
	
	@Id
	private int repas_id;
	
	@Id
	private int pilote_id;
	
	@ManyToOne
	@JoinColumn
	public Pilote pilote;
	
	@ManyToOne
	@JoinColumn
	public Repas repas;

	@Override
	public String toString() {
		return "Reservation [nbPersonnes=" + nbPersonnes + ", repas_id="
				+ repas_id + ", pilote_id=" + pilote_id + ", pilote=" + pilote
				+ ", repas=" + repas + "]";
	}

}
