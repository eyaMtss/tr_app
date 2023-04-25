package com.tunidesign.contratmicroservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContratRequestDto {
    @Id
    private Long id ;
    private int type ;
    private float prix ;



}
