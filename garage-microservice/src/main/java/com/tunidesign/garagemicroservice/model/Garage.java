package com.tunidesign.garagemicroservice.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "garage")
public class Garage {
    @Transient
    public static final String SEQUENCE_NAME = "garage_sequence";

    @Id
    private Long id;
    private String name;
    private String email;
    private Integer phone;
    private String countryCode;
    private String dialCode;
    private String adresse;
    private String garageType;
    private Long garageOwner;
    private int capacite;
}
