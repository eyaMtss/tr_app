package com.tunidesign.parkingmicroservice.DTO;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class ParkingResponseDTO {
    private Long parkingId;
    private String name;
    private Integer capacity;
    private Integer nbVehicle;
    private String country;
    private String governorate;
    private String city;
    private Integer zipCode;
    private Double longitude;
    private Double latitude;
    private Long garageId;
}