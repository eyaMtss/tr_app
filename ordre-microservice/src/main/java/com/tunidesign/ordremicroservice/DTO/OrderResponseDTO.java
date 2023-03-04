package com.tunidesign.ordremicroservice.DTO;

import com.tunidesign.ordremicroservice.model.ennumeration.BreakdownType;
import com.tunidesign.ordremicroservice.model.ennumeration.IsLoaded;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Max;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderResponseDTO {
    private int id;
    @Max(value = 8)
    private int people;
    //@Max(8)
    //@Size(length=8,  message="verifier votre numéro de téléphone ")
    @Column(length = 8)
    private int telephone;
    @Enumerated(EnumType.STRING)
    private BreakdownType breakdownType;
    private int breakdownDetails;
    @Enumerated(EnumType.STRING)
    private IsLoaded isLoaded;
    private Date orderTimeRequest;
    private Date orderTimeAccept;
    private int idVehicule;
    private String positionALong;
    private String positionAAtt;
    private String positionBLong;
    private String positionBAtt;
    private String positionCLong;
    private String positionCAtt;
}
