package fr.eservices.soaring.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
public class Vol {
	@Id
	@GeneratedValue
	private String vol_id;
	
	private String date;
	private String heureDecollage;
	private String heureAtterrissage;
	
	@ManyToOne
	public Pilote pilote;
	@ManyToOne
	public Epreuve epreuve;
	
}
