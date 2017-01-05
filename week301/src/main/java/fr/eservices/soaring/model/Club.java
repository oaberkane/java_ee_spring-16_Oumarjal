package fr.eservices.soaring.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
public class Club {
	@Id
	@GeneratedValue
	private String id;
	
	
	private String nom;
	private String ville;
	
	
	@ManyToOne
	public Region region;
	
	

}
