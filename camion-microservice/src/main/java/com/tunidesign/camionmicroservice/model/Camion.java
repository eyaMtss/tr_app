package com.tunidesign.camionmicroservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Camion {
	@Id
	private int id; 
	private String matricule ; 
	private int modele ;
	private int charge ;
	private int poids ;
	public Camion() {
	super();
	// TODO Auto-generated constructor stub
}
public Camion(int id, String matricule, int modele, int charge, int poids) {
	super();
	this.id = id;
	this.matricule = matricule;
	this.modele = modele;
	this.charge = charge;
	this.poids = poids;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getMatricule() {
	return matricule;
}
public void setMatricule(String matricule) {
	this.matricule = matricule;
}
public int getModele() {
	return modele;
}
public void setModele(int modele) {
	this.modele = modele;
}
public int getCharge() {
	return charge;
}
public void setCharge(int charge) {
	this.charge = charge;
}
public int getPoids() {
	return poids;
}
public void setPoids(int poids) {
	this.poids = poids;
}
@Override
public String toString() {
	return "camion [id=" + id + ", matricule=" + matricule + ", modele=" + modele + ", charge=" + charge + ", poids="
			+ poids + "]";
}

}
