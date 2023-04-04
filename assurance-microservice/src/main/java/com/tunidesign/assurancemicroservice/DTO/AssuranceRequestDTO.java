package com.tunidesign.assurancemicroservice.DTO;

import jakarta.persistence.Column;
import jakarta.persistence.Lob;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AssuranceRequestDTO {
        private String name;
        private String adresse;
        @Email
        private String email;
        private Integer phoneNumber;

        private String countryCode;
        private String dialCode;
        private String webSite;
}
