package com.tunidesign.utilisateurmicroservice.model.entity;

import java.util.Date;

import com.tunidesign.utilisateurmicroservice.model.enumeration.Gender;
import com.tunidesign.utilisateurmicroservice.model.enumeration.Role;
import com.tunidesign.utilisateurmicroservice.model.enumeration.Status;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "users")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long userId;
	// Authentication
	//@Column(unique = true)
	private String username;
	@Email
	//@Column(unique = true)
	private String email;
	//@ValidPassword
	private byte[] salt;
	private String password;
	//@PasswordMatches
	private String confirmPassword;
	@Column(name = "firstname")
	private String firstName;
	@Column(name = "lastname")
	private String lastName;
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
	//@Column(unique = true)
	private Long phoneNumber;

	// Picture
	private String pictureName;
	private String pictureType;
	@Lob
	@Column(length = 1000000000, columnDefinition = "LONGBLOB")
	private byte[] pictureByte;
	//@Column(unique = true)
	private String matriculeFiscale; // employee
	@Enumerated(EnumType.STRING)
	private Status status; // employee
	private Long companyId;	// TA && DRIVER
	private Long insuranceCompanyId; // Insurance && expert
	private Long agencyId; // Agency
	@Enumerated(EnumType.STRING)
    private Role role;

}
