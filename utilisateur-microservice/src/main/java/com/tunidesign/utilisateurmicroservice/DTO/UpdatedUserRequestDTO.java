package com.tunidesign.utilisateurmicroservice.DTO;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Getter
@Setter
@Builder
public class UpdatedUser {
    private String username;
    private String country;
    private String governorate;
    private String city;
    private Integer zipCode;
    private Integer homeCode;
    private String matriculeFiscale;
}
