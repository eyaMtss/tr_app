package com.tunidesign.Ordermicroservice.model;


import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table
public class Order {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    //@Max(2)
    private int people;
    //@Max(8)
    private int telephone ;
    private int breakdown_type;
    private int breakdown_details;
    private int is_loaded ;
    private Date order_time_request;
    private Date order_time_accept ;
    private int id_vehicule ;
    private String positionALong;
    private String positionAAtt;

    private String positionBLong;
    private String positionBAtt;

    private String positionCLong;
    private String positionCAtt;


    public Order()
    {
    }
    public Order(int id , int people, int telephone, int breakdown_type, int breakdown_details, int is_loaded , Date order_time_request, Date order_time_accept, int id_vehicule, String positionALong, String positionAAtt,
                 String positionBLong , String positionBAtt, String positionCLong, String positionCAtt)
    {
        this.id=id;
        this.people=people;
        this.telephone=telephone;
        this.breakdown_type=breakdown_type;
        this.breakdown_details = breakdown_details;
        this.is_loaded=is_loaded;
        this.order_time_request=order_time_request;
        this.order_time_accept=order_time_accept;
        this.id_vehicule=id_vehicule;
        this.positionALong = positionALong;
        this.positionAAtt=positionAAtt;
        this.positionBLong=positionBLong;
        this.positionBAtt=positionBAtt;
        this.positionCLong=positionCLong;
        this.positionCAtt=positionCAtt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPeople() {
        return people;
    }

    public void setPeople(int people) {
        this.people = people;
    }

    public int getTelephone() {
        return telephone;
    }

    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }

    public int getBreakdown_type() {
        return breakdown_type;
    }

    public void setBreakdown_type(int breakdown_type) {
        this.breakdown_type = breakdown_type;
    }

    public int getBreakdown_details() {
        return breakdown_details;
    }

    public void setBreakdown_details(int breakdown_details) {
        this.breakdown_details = breakdown_details;
    }

    public int getIs_loaded() {
        return is_loaded;
    }

    public void setIs_loaded(int is_loaded) {
        this.is_loaded = is_loaded;
    }

    public Date getOrder_time_request() {
        return order_time_request;
    }

    public void setOrder_time_request(Date order_time_request) {
        this.order_time_request = order_time_request;
    }

    public Date getOrder_time_accept() {
        return order_time_accept;
    }

    public void setOrder_time_accept(Date order_time_accept)
    {
        this.order_time_accept = order_time_accept;
    }
    public int getId_vehicule() {
        return id_vehicule;
    }

    public void setId_vehicule(int id_vehicule) {
        this.id_vehicule = id_vehicule;
    }

    public String getPositionAAtt() {
        return positionAAtt;
    }

    public void setPositionAAtt(String positionAAtt) {
        this.positionAAtt = positionAAtt;
    }

    public String getPositionALong() {
        return positionALong;
    }

    public void setPositionALong(String positionALong) {
        this.positionALong = positionALong;
    }

    public String getPositionBAtt() {
        return positionBAtt;
    }

    public void setPositionBAtt(String positionBAtt) {
        this.positionBAtt = positionBAtt;
    }

    public String getPositionBLong() {
        return positionBLong;
    }

    public void setPositionBLong(String positionBLong) {
        this.positionBLong = positionBLong;
    }

    public String getPositionCAtt() {
        return positionCAtt;
    }

    public void setPositionCAtt(String positionCAtt) {
        this.positionCAtt = positionCAtt;
    }

    public String getPositionCLong() {
        return positionCLong;
    }

    public void setPositionCLong(String positionCLong) {
        this.positionCLong = positionCLong;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", people=" + people +
                ", telephone=" + telephone +
                ", breakdown_type=" + breakdown_type +
                ", breakdown_details=" + breakdown_details +
                ", is_loaded=" + is_loaded +
                ", order_time_request=" + order_time_request +
                ", order_time_accept=" + order_time_accept +
                ", id_vehicule=" + id_vehicule +
                ", positionALong='" + positionALong + '\'' +
                ", positionAAtt='" + positionAAtt + '\'' +
                ", positionBLong='" + positionBLong + '\'' +
                ", positionBAtt='" + positionBAtt + '\'' +
                ", positionCLong='" + positionCLong + '\'' +
                ", positionCAtt='" + positionCAtt + '\'' +
                '}';
    }
}

