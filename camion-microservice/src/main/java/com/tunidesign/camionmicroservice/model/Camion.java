package com.tunidesign.camionmicroservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "camion")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Camion {
	@Id
	private Long id;
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
