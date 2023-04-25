package com.tunidesign.facturemicroservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FactureResponseDto {
    @Id
    private Long id;
    private long numero;
    private Date date;
    private Float prix;
}