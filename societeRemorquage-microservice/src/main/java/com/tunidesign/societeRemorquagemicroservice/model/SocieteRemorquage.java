package com.tunidesign.societeRemorquagemicroservice.model;

import jakarta.persistence.*;
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
    private int id;

    private String adresse;
}
