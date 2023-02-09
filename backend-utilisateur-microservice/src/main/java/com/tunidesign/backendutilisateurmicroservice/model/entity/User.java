package com.tunidesign.backendutilisateurmicroservice.model.entity;

import java.util.Date;

import com.tunidesign.backendutilisateurmicroservice.model.enumeration.Gender;
import com.tunidesign.backendutilisateurmicroservice.model.enumeration.Role;
import com.tunidesign.backendutilisateurmicroservice.model.enumeration.Status;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User {
	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	private Long userId;
	//@NotBlank(message = "Firstname may not be blank")
	private String firstname;
	//@NotBlank(message = "Lastname may not be blank")
	private String lastname;
	@Enumerated(EnumType.STRING)
	private Gender gender; // F/M
	//@NotBlank(message = "Birthdate may not be blank")
	private Date birthdate;

	// Address
	private String country;
	private String governorate;
	private String city;
	private Integer zipCode;
	private Integer homeCode;

	// Contact
	@Email
	//@NotBlank(message = "Email may not be blank")
	private String email;
	//@NotEmpty(message = "Phone number may not be blank")
	private Long phoneNumber;

	// Picture
	private String pictureName;
	private String pictureType;
	// image bytes can have large lengths so we specify a value
	// which is more than the default length for picByte column
	@Lob
	@Column(length = 1000000000, columnDefinition = "LONGBLOB")
	private byte[] pictureByte;

	// employee
	private String matriculeFiscale;
	@Enumerated(EnumType.STRING)
	private Status status;

	// TA && DRIVER
	private Long companyId;
	// Insurance
	private Long insuranceCompanyId;
	// Agency
	private Long agencyId;
	
	// Role
	@Enumerated(EnumType.STRING)
    private Role role;

}
