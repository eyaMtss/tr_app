package com.tunidesign.utilisateurmicroservice.DTO;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Getter
@Setter
@Builder
public class UpdatedUserRequestDTO {
    private String username;
    private String country;
    private String governorate;
    private String city;
    private Integer zipCode;
    private String matriculeFiscale;
    private Integer cin;
}
