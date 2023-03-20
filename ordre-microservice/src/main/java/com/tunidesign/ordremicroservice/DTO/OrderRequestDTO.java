package com.tunidesign.ordremicroservice.DTO;

import com.tunidesign.ordremicroservice.model.ennumeration.BreakdownType;
import com.tunidesign.ordremicroservice.model.ennumeration.IsLoaded;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Lob;
import jakarta.validation.constraints.Max;
import lombok.*;

import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class OrderRequestDTO {
        private int id;
        @Max(value=8)
        private int people;
        //@Max(8)
        //@Size(length=8,  message="verifier votre numéro de téléphone ")
        @Column(length = 8)
        private int telephone ;
        @Enumerated(EnumType.STRING)
        private BreakdownType breakdownType;
        private String breakdownDetails;
        @Enumerated(EnumType.STRING)
        private IsLoaded isLoaded ;
        private Date orderTimeRequest;
        private int serie;
        private String positionALong;
        private String positionAAtt;
        private String positionBLong;
        private String positionBAtt;
        private String positionCLong;
        private String positionCAtt;
        @Lob
        @Column(length=10000000, columnDefinition="longblob")
        private byte[] img1;
        @Lob
        @Column(length=10000000, columnDefinition="longblob")
        private byte[] img2;
        @Lob
        @Column(length=10000000, columnDefinition="longblob")
        private byte[] img3;
        private String typeImmatriculation;
        private int numImmatriculation ;
        private int numChassis ;

}
