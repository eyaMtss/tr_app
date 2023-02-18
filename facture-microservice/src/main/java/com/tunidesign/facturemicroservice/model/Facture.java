package com.tunidesign.facturemicroservice.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table
public class Facture {
    @Id
    private int id;
    private long numero;
    private Date date;
    private Float prix;
    public Facture()
    {
    }
    public Facture(int id, long numero, Date date ,Float prix)
    {
        this.id = id;
        this.numero=numero ;
        this.date=date ;
        this.prix=prix;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getNumero() {
        return numero;
    }

    public void setNumero(long numero) {
        this.numero = numero;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Float getPrix() {
        return prix;
    }

    public void setPrix(Float prix) {
        this.prix = prix;
    }

    @Override
    public String toString() {
        return "Facture{" +
                "id=" + id +
                ", numero=" + numero +
                ", date=" + date +
                ", prix=" + prix +
                '}';
    }
}
