package com.tunidesign.facturemicroservice.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FactureRequestDTO {

        @Id
        private int id;
        private long numero;
        private Date date;
        private Float prix;
}
