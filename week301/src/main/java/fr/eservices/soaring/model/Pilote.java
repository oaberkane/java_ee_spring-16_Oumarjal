package fr.eservices.soaring.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
public class Pilote {
	
	@Id
	@GeneratedValue
	private String id;
	
	private String nom;
	private String prenom;
	private Date dateNaissance;
	private String adresse;
	private String codePostal;
	private String ville;
	private String telPortable;
	
	
	@ManyToOne
	public Club club;


	@Override
	public String toString() {
		return "Pilote [id=" + id + ", nom=" + nom + ", prenom=" + prenom
				+ ", dateNaissance=" + dateNaissance + ", adresse=" + adresse
				+ ", codePostal=" + codePostal + ", ville=" + ville
				+ ", telPortable=" + telPortable + ", club=" + club + "]";
	}
	
	

}
