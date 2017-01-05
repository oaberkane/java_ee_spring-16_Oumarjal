package fr.eservices.soaring.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
public class Produit {
	
	@Id
	@GeneratedValue
	public int id;
	
	private String libelle;
	private String prixUnitaire;
	
	@ManyToOne
	public Categorie categorie;
	
}
