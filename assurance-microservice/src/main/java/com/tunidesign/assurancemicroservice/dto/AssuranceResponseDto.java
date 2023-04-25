package com.tunidesign.assurancemicroservice.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Lob;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AssuranceResponseDto {
    private Long id;
    private String name;
    private String adresse;
    @Email
    private String email;
    private Integer phoneNumber;

    private String countryCode;
    private String dialCode;
    private String pictureName;
    private String pictureType;
    @Lob
    @Column(length = 1000000000, columnDefinition = "LONGBLOB")
    private byte[] pictureByte;
    private String webSite;
}
