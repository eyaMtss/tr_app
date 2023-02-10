package com.tunidesign.backendutilisateurmicroservice.DTO;

import java.util.Date;

import com.tunidesign.backendutilisateurmicroservice.model.enumeration.Gender;
import com.tunidesign.backendutilisateurmicroservice.model.enumeration.Status;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompanyUserRequestDTO {
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

	// TA && DRIVER && admin
	private Long companyId;

	// Authentication
	private String login;
	private String password;
	private String confirmPassword;
}
