package com.tunidesign.societeRemorquagemicroservice.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class SocieteRemorquageResponseDTO {
    private int id;
    private String adresse;
}
