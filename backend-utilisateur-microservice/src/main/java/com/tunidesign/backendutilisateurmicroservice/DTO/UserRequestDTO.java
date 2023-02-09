package com.tunidesign.backendutilisateurmicroservice.DTO;

import java.util.Date;

import com.tunidesign.backendutilisateurmicroservice.model.enumeration.Role;

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
public class UserRequestDTO {
	private Long userId;
	private String firstname;
	private String lastname;
	private Integer gender;
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
	private Integer status;

	// TA && DRIVER
	private Long companyId;
	// Insurance
	private Long insuranceCompanyId;
	// Agency
	private Long agencyId;
	@Enumerated(EnumType.STRING)
    private Role role;
}
