package fr.eservices.soaring.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.Table;


@Entity
@Inheritance
public class Repas {
	
	@Id
	@GeneratedValue
	private int id;
	
	private Date date;
	private String heure;
	private String menu;
	@Override
	public String toString() {
		return "Repas [id=" + id + ", date=" + date + ", heure=" + heure
				+ ", menu=" + menu + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getHeure() {
		return heure;
	}
	public void setHeure(String heure) {
		this.heure = heure;
	}
	public String getMenu() {
		return menu;
	}
	public void setMenu(String menu) {
		this.menu = menu;
	}
	
}
