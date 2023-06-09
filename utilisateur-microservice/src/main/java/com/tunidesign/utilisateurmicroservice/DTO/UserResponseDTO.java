package com.tunidesign.utilisateurmicroservice.DTO;

import java.util.Date;

import com.tunidesign.utilisateurmicroservice.model.enumeration.Gender;
import com.tunidesign.utilisateurmicroservice.model.enumeration.Status;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Lob;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserResponseDTO {
	private Long userId;
	private String firstName;
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
	@Email
	private String email;
	private Long phoneNumber;
	private String countryCode;
	private String dialCode;

	// Picture
	private String pictureName;
	@Lob
	//@Column(length = 1000000000, columnDefinition = "LONGBLOB")
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
	private Boolean isRegistrationCompleted;
}
