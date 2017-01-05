package fr.eservices.soaring.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
public class Epreuve {

@Id
@GeneratedValue
private String id;

private String jour;
private Status status;
private Type type;

	
}
