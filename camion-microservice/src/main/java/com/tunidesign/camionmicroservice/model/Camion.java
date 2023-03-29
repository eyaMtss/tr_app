package com.tunidesign.camionmicroservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@Data
@AllArgsConstructor
@Builder
public class Camion {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int id; 
	private String matricule ;

	private String type;

	private int porte;
    private String typeImmat;
	private String typePoidsLourd;

	private int serie;
	private int numImmat;
	private int numChassis;
	private String modele ;
	private int charge ;
	private int poids ;
	public Camion() {
	super();
	// TODO Auto-generated constructor stub
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
public String getModele() {
	return modele;
}
public void setModele(String modele) {
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
