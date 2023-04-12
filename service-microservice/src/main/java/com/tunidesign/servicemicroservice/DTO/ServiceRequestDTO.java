package com.tunidesign.servicemicroservice.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ServiceRequestDTO {

        @Id
        private Long id;
        private String nom ;
        private Float prix ;
}
