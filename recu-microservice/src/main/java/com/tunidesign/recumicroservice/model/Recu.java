package com.tunidesign.recumicroservice.model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection = "recu")
public class Recu {
    @Id
    private Long id ;
    private String id_services ;
    private Float prix_total;

}

