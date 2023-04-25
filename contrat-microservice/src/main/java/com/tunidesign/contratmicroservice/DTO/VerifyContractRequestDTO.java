package com.tunidesign.contratmicroservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class VerifyContractRequestDto {
    private String numContrat;
    private int numChassis;
}
