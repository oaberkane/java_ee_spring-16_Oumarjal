package fr.eservices.soaring.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
public class Utilisateur {
	@Id
	@GeneratedValue
	private String identifiant;
	
	private String motDePasse;
	private String nom;
	private String prenom;
	
	
	@ManyToOne
	public Profil profil;

}
