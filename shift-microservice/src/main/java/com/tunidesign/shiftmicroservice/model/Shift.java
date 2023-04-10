package com.tunidesign.shiftmicroservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalTime;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "shift")
public class Shift {
    @Id
    private Long id;

     private Date date ;

     private LocalTime heureDebut;

     private LocalTime heureFin;

     private int idAgence ;
}
