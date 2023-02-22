package com.tunidesign.contratmicroservice.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContratResponseDTO {
    @Id
    private int id ;
    private int type ;
    private float prix ;

}