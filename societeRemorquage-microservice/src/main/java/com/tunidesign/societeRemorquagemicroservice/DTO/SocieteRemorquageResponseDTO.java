package com.tunidesign.societeRemorquagemicroservice.DTO;

import jakarta.persistence.Lob;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class SocieteRemorquageResponseDTO {
    private Long id;
    private String name;
    private String country;
    private String governorate;
    private String city;
    private Integer zipCode;
    private Double lattitude;
    private Double longitude;
    private Long phone1;
    private Long phone2;
    @Email
    private String email;
    private String logoName;
    private String logoType;
    @Lob
    //@Column(length = 1000000000, columnDefinition = "LONGBLOB")
    private byte[] logoByte;
}
