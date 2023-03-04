package com.tunidesign.shiftmicroservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;
import java.util.Date;

@Data
@Builder
@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
public class Shift {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;

     private Date date ;

     private LocalTime heureDebut;

     private LocalTime heureFin;

     private int idAgence ;
}
