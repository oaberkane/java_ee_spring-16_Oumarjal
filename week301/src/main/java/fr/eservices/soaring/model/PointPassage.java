package fr.eservices.soaring.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
public class PointPassage {
	@Id
	@GeneratedValue
	public int id;
	
	private String nom;
	private String lattitude;
	private String longitude;
	private String description;

}
