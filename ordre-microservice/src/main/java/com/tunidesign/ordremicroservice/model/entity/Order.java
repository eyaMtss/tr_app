package com.tunidesign.ordremicroservice.model.entity;

import com.tunidesign.ordremicroservice.model.ennumeration.BreakdownType;
import com.tunidesign.ordremicroservice.model.ennumeration.IsLoaded;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Order {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    @Max(value=8)
    private int people;
    //@Max(8)
    //@Size(length=8,  message="verifier votre numéro de téléphone ")
    @Column(length = 8)
    private int telephone ;
    @Enumerated(EnumType.STRING)
    private BreakdownType breakdownType;
    private int breakdownDetails;
    @Enumerated(EnumType.STRING)
    private IsLoaded isLoaded ;
    private Date orderTimeRequest;
    private Date orderTimeAccept ;
    private int idVehicule ;
    private String positionALong;
    private String positionAAtt;
    private String positionBLong;
    private String positionBAtt;
    private String positionCLong;
    private String positionCAtt;
}

