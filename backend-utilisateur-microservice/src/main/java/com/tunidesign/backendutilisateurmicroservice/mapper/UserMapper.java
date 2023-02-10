package com.tunidesign.backendutilisateurmicroservice.mapper;

import com.tunidesign.backendutilisateurmicroservice.DTO.AgencyUserRequestDTO;
import com.tunidesign.backendutilisateurmicroservice.DTO.AgencyUserResponseDTO;
import com.tunidesign.backendutilisateurmicroservice.DTO.AuthenticationResponseDTO;
import com.tunidesign.backendutilisateurmicroservice.DTO.ClientRequestDTO;
import com.tunidesign.backendutilisateurmicroservice.DTO.ClientResponseDTO;
import com.tunidesign.backendutilisateurmicroservice.DTO.CompanyUserRequestDTO;
import com.tunidesign.backendutilisateurmicroservice.DTO.CompanyUserResponseDTO;
import com.tunidesign.backendutilisateurmicroservice.DTO.InsuranceUserRequestDTO;
import com.tunidesign.backendutilisateurmicroservice.DTO.InsuranceUserResponseDTO;
import com.tunidesign.backendutilisateurmicroservice.DTO.UserRequestDTO;
import com.tunidesign.backendutilisateurmicroservice.DTO.UserResponseDTO;
import com.tunidesign.backendutilisateurmicroservice.model.entity.User;

public interface UserMapper {
	UserResponseDTO userToUserResponseDTO(User user);
	User userRequestDTOToUser(UserRequestDTO userRequestDTO);
	
	ClientResponseDTO userToClientResponseDTO(User user);
	User clientRequestDTOToUser(ClientRequestDTO clientRequestDto);
	
	CompanyUserResponseDTO userToCompanyUserResponseDTO(User user);
	User companyUserRequestDTOToUser(CompanyUserRequestDTO companyUsersRequestDto);
	
	AgencyUserResponseDTO userToAgencyUserResponseDTO(User user);
	User agencyUserRequestDTOToUser(AgencyUserRequestDTO agencyUsersRequestDto);

	InsuranceUserResponseDTO userToInsuranceUserResponseDTO(User user);
	User insuranceUserRequestDTOToUser(InsuranceUserRequestDTO insuranceUsersRequestDto);

	AuthenticationResponseDTO userToAuthenticationResponseDTO(User user);
}
