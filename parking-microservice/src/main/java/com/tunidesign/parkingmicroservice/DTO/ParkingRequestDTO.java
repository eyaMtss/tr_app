package com.tunidesign.parkingmicroservice.DTO;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class ParkingRequestDTO {
    private String name;
    private Integer capacity;
    private Integer nbVehicle;
    private String country;
    private String governorate;
    private String city;
    private String zipCode;
    private Double longitude;
    private Double latitude;
    private Long idGarage;
}
