package com.tunidesign.utilisateurservice.DTO;

import java.util.Date;

import com.tunidesign.utilisateurservice.model.enumeration.Gender;
import com.tunidesign.utilisateurservice.model.enumeration.Status;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Lob;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompanyUserResponseDTO {
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

	// employee
	private String matriculeFiscale;
	@Enumerated(EnumType.STRING)
	private Status status;
	// Picture
	private String pictureName;
	@Lob
	//@Column(length = 1000000000, columnDefinition = "LONGBLOB")
	private byte[] pictureByte;

	// TA && DRIVER && admin
	private Long companyId;
}