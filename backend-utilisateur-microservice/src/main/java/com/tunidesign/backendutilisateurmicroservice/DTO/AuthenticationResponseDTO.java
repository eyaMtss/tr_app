package com.tunidesign.backendutilisateurmicroservice.DTO;

import com.tunidesign.backendutilisateurmicroservice.model.enumeration.Role;

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
	private String login;
	private Role role;
}
