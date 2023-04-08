package com.tunidesign.servicemicroservice.model;

import jakarta.persistence.*;

@Table
@Entity
public class Service {
    @Id
    private int id;
    private String nom ;
    private Float prix ;

    public Service() {

    }

    public Service(int id, String nom , Float prix) {
        this.id = id;
        this.nom=nom;
        this.prix=prix;
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

    public Float getPrix() {
        return prix;
    }

    public void setPrix(Float prix) {
        this.prix = prix;
    }

    @Override
    public String toString() {
        return "Service{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prix=" + prix +
                '}';
    }
}
