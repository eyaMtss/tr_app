package com.tunidesign.utilisateurmicroservice.DTO;

import com.tunidesign.utilisateurmicroservice.model.enumeration.Role;

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
public class AuthenticationResponseDTO {
	private String identifier;
	private String role;
	private String password;
}
