package com.tunidesign.vehiculemicroservice.model.entity;

import com.tunidesign.vehiculemicroservice.model.ennumeration.Couleur;
import com.tunidesign.vehiculemicroservice.model.ennumeration.Marque;
import jakarta.persistence.*;
@Table
@Entity
public class Vehicule {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id ;
    private String numImmat;
    private int poids;
    @Enumerated(EnumType.STRING)
    private Couleur couleur;
    private int kilométrage;
    private int nbPortes;
    private int Puissance;
    @Enumerated(EnumType.STRING)
    private Marque Marque;

    public Vehicule() {

    }

    public Vehicule(int id, String numImmat, int poids, Couleur couleur, int kilométrage, int nbPortes, int puissance, com.tunidesign.vehiculemicroservice.model.ennumeration.Marque marque) {
        this.id = id;
        this.numImmat = numImmat;
        this.poids = poids;
        this.couleur = couleur;
        this.kilométrage = kilométrage;
        this.nbPortes = nbPortes;
        Puissance = puissance;
        Marque = marque;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumImmat() {
        return numImmat;
    }

    public void setNumImmat(String numImmat) {
        this.numImmat = numImmat;
    }

    public int getPoids() {
        return poids;
    }

    public void setPoids(int poids) {
        this.poids = poids;
    }

    public Couleur getCouleur() {
        return couleur;
    }

    public void setCouleur(Couleur couleur) {
        this.couleur = couleur;
    }

    public int getKilométrage() {
        return kilométrage;
    }

    public void setKilométrage(int kilométrage) {
        this.kilométrage = kilométrage;
    }

    public int getNbPortes() {
        return nbPortes;
    }

    public void setNbPortes(int nbPortes) {
        this.nbPortes = nbPortes;
    }

    public int getPuissance() {
        return Puissance;
    }

    public void setPuissance(int puissance) {
        Puissance = puissance;
    }

    public com.tunidesign.vehiculemicroservice.model.ennumeration.Marque getMarque() {
        return Marque;
    }

    public void setMarque(com.tunidesign.vehiculemicroservice.model.ennumeration.Marque marque) {
        Marque = marque;
    }
}
