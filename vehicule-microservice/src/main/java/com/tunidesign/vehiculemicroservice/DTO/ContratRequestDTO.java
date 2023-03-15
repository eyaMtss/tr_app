package com.tunidesign.vehiculemicroservice.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ContratRequestDTO {
    private String numContrat;
    private Long numChassis;
}
