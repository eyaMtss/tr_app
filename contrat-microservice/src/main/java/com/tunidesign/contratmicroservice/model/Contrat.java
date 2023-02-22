package com.tunidesign.contratmicroservice.model;


import jakarta.persistence.*;

@Entity
@Table
public class Contrat
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id ;
    private int type ;
    private float prix ;

    public Contrat() {
    }

    public Contrat(int id,int type , float prix  ) {
        this.id=id;
        this.type = type;
        this.prix = prix;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Contrat{" +
                "id=" + id +
                ", type=" + type +
                ", prix=" + prix +
                '}';
    }
}