package com.tunidesign.societeRemorquagemicroservice.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class SocieteRemorquage {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
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
