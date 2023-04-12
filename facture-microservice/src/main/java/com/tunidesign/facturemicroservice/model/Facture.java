package com.tunidesign.facturemicroservice.model;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "facture")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Facture {
    @Id
    private int id;
    private long numero;
    private Date date;
    private Float prix;
}
