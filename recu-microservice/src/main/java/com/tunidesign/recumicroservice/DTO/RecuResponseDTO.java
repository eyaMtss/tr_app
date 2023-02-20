package com.tunidesign.recumicroservice.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RecuResponseDTO {
    @Id
    private int id ;
    private String id_services ;
    private Float prix_total;
}