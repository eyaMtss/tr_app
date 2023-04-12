package com.tunidesign.contratmicroservice.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class VerifyContractRequestDTO {
    private String numContrat;
    private int numChassis;
}
