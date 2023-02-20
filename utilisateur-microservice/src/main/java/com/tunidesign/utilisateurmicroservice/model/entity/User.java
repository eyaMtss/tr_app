package com.tunidesign.utilisateurmicroservice.model.entity;

import java.util.Date;

import com.tunidesign.utilisateurmicroservice.model.enumeration.Gender;
import com.tunidesign.utilisateurmicroservice.model.enumeration.Role;
import com.tunidesign.utilisateurmicroservice.model.enumeration.Status;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
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
	// Authentication
	private String login;
	//@ValidPassword
	private String password;
	//@PasswordMatches
	private String confirmPassword;
	// Picture
	private String pictureName;
	private String pictureType;
	@Lob
	//@Column(length = 1000000000, columnDefinition = "LONGBLOB")
	private byte[] pictureByte;
	private String matriculeFiscale; // employee
	@Enumerated(EnumType.STRING)
	private Status status; // employee
	private Long companyId;	// TA && DRIVER
	private Long insuranceCompanyId; // Insurance && expert
	private Long agencyId; // Agency
	@Enumerated(EnumType.STRING)
    private Role role;

}
