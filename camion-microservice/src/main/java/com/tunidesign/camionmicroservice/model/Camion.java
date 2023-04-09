package com.tunidesign.camionmicroservice.model;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collation = "camion")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Camion {
	@Id
	private int id; 
	private String matricule ;

	private String type;

	private int porte;
    private String typeImmat;
	private String typePoidsLourd;

	private int serie;
	private int numImmat;
	private int numChassis;
	private String modele ;
	private int charge ;
	private int poids ;
}
