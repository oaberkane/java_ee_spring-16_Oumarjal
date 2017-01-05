package fr.eservices.soaring.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
public class Region {
	@Id
	@GeneratedValue
	private int id;
	
	private String nom;
	

}
