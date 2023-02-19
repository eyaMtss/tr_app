package com.tunidesign.utilisateurservice.DTO;

import java.util.Date;

import com.tunidesign.utilisateurservice.model.enumeration.Gender;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Lob;
import javax.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientResponseDTO {
	private Long userId;
	private String firstname;
	private String lastname;
	@Enumerated(EnumType.STRING)
	private Gender gender;
	private Date birthdate;

	// Address
	private String country;
	private String governorate;
	private String city;
	private Integer zipCode;
	private Integer homeCode;

	// Contact
	@Email
	private String email;
	private Long phoneNumber;

	// Picture
	private String pictureName;
	@Lob
	//@Column(length = 1000000000, columnDefinition = "LONGBLOB")
	private byte[] pictureByte;
}
