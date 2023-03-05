package com.tunidesign.parkingmicroservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Parking {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long parkingId;
    private String name;
    private Long parkingOwner;
    private Integer capacity;
    private Integer nbVehicle;
    private String country;
    private String governorate;
    private String city;
    private Integer zipCode;
    private Double longitude;
    private Double latitude;

}