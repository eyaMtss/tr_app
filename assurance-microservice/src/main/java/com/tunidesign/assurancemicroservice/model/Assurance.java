package com.tunidesign.assurancemicroservice.model;

import jakarta.persistence.Lob;
import org.springframework.data.annotation.Id;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "assurance")
public class Assurance {
    @Transient
    public static final String SEQUENCE_NAME = "vehicule_sequence";
    @Id
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
   // @Column(length = 1000000000, columnDefinition = "LONGBLOB")
    private byte[] pictureByte;
    private String webSite;

}
