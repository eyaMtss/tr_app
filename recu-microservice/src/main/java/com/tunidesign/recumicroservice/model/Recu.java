package com.tunidesign.recumicroservice.model;
import jakarta.persistence.*;

@Table
@Entity
public class Recu {
    @Id
    private int id ;
    private String id_services ;
    private Float prix_total;
    public Recu()
    {
    }
    public Recu(int id , String id_services ,Float prix_total ) {
        this.id = id;
        this.id_services=id_services;
        this.prix_total=prix_total;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getId_services() {
        return id_services;
    }
    public void setId_services(String id_services) {
        this.id_services = id_services;
    }
    public Float getPrix_total() {
        return prix_total;
    }
    public void setPrix_total(Float prix_total) {
        this.prix_total = prix_total;
    }
    @Override
    public String toString() {
        return "Recu{" +
                "id=" + id +
                ", id_services='" + id_services + '\'' +
                ", prix_total=" + prix_total +
                '}';
    }
}

