package fr.eservices.soaring.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
public class Secteur implements Serializable{

	
	private String rayon;
	private String type;
	
	
	@Id
	private int epreuve_id;
	
	@Id
	private int pointPassage_id;
	
	@ManyToOne
	@JoinColumn
	public Epreuve epreuve;
	
	@ManyToOne
	@JoinColumn
	public PointPassage pointPassage;
	
}
