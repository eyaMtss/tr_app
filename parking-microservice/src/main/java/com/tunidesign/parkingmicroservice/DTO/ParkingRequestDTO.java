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
