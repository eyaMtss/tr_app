package com.tunidesign.utilisateurmicroservice.DTO;

import java.util.Date;

import com.tunidesign.utilisateurmicroservice.model.enumeration.Gender;
import com.tunidesign.utilisateurmicroservice.model.enumeration.Role;
import com.tunidesign.utilisateurmicroservice.model.enumeration.Status;

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
	private String firstName;
	private String lastName;
	private String username;
	@Enumerated(EnumType.STRING)
	private Gender gender;
	private Date birthdate;
	// Contact
	@Email
	private String email;
	private Long phoneNumber;
	private Long societeRemorquageId; // TA && DRIVER && admin
	private Long societeLocationId;
	private Long insuranceCompanyId; // Insurance && Expert
	// Authentication
	private String password;
	private String confirmPassword;
	@Enumerated(EnumType.STRING)
	private Role role;
}
