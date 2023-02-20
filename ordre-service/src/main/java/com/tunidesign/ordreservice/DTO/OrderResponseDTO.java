package com.tunidesign.ordreservice.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderResponseDTO {
    @Id
    private int id;
    private int people;
    private int telephone ;
    private int breakdown_type;
    private int breakdown_details;
    private int is_loaded ;
    private Date order_time_request;
    private Date order_time_accept ;
    private int id_vehicule ;
    private String positionALong;
    private String positionAAtt;
    private String positionBLong;
    private String positionBAtt;
    private String positionCLong;
    private String positionCAtt;
}
