package fr.eservices.soaring.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
public class Categorie {
	@Id
	@GeneratedValue
	public int id;
	
	private String titre;


}
