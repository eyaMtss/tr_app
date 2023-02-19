package com.tunidesign.utilisateurservice.DTO;

import java.util.Date;

import com.tunidesign.utilisateurservice.model.enumeration.Gender;
import com.tunidesign.utilisateurservice.model.enumeration.Status;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Email;
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
	// Insurance && Expert
	private Long insuranceCompanyId;
	// Agency
	private Long agencyId;

	// Authentication
	private String login;
	private String password;
	private String confirmPassword;
}
