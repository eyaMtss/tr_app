package com.example.agencemicroservice.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;

@Entity
@Table
public class Agence
{ @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int numero ;
    private String nom ;
    private int telephone ;
    private String responsable ;
    @Email
    private String email ;
    private String ville  ;
    private String  paye;
    private String gouvernerat ;

    public Agence() {
    }

    public Agence(int id  , String nom , int telephone ) {
        this.id = id;
        this .nom = nom ;
        this.telephone= telephone;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getTelephone() {
        return telephone;
    }

    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public String getResponsable() {
        return responsable;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }

    public String getGouvernerat() {
        return gouvernerat;
    }

    public void setGouvernerat(String gouvernerat) {
        this.gouvernerat = gouvernerat;
    }

    public String getPaye() {
        return paye;
    }

    public void setPaye(String paye) {
        this.paye = paye;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    @Override
    public String toString() {
        return "Agence{" +
                "id=" + id +
                ", numero=" + numero +
                ", nom='" + nom + '\'' +
                ", telephone=" + telephone +
                ", responsable='" + responsable + '\'' +
                ", email='" + email + '\'' +
                ", ville='" + ville + '\'' +
                ", paye='" + paye + '\'' +
                ", gouvernerat='" + gouvernerat + '\'' +
                '}';
    }
}
