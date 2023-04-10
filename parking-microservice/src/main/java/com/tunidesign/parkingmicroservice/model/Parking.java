package com.tunidesign.parkingmicroservice.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document("parking")
public class Parking {
    @Transient
    public static final String SEQUENCE_NAME = "parking_sequence";
    @Id
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
    public Parking(String name, Long parkingOwner, Integer capacity, Integer nbVehicle, String country, String governorate, String city, Integer zipCode, Double longitude, Double latitude) {
        this.name = name;
        this.parkingOwner = parkingOwner;
        this.capacity = capacity;
        this.nbVehicle = nbVehicle;
        this.country = country;
        this.governorate = governorate;
        this.city = city;
        this.zipCode = zipCode;
        this.longitude = longitude;
        this.latitude = latitude;
    }
}
