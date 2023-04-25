package com.tunidesign.assurancemicroservice.dto;

import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AssuranceRequestDto {
        private String name;
        private String adresse;
        @Email
        private String email;
        private Integer phoneNumber;

        private String countryCode;
        private String dialCode;
        private String webSite;
}
