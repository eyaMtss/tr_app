package com.tunidesign.garagemicroservice.model;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "garage")
public class Garage {
    @Id
        private Long id;

    private String name;
    private String adresse;

    private int capacite;
    private Long garageOwner;
}
