package com.tunidesign.utilisateurservice.mapper;

import com.tunidesign.utilisateurservice.DTO.AgencyUserRequestDTO;
import com.tunidesign.utilisateurservice.DTO.AgencyUserResponseDTO;
import com.tunidesign.utilisateurservice.DTO.AuthenticationResponseDTO;
import com.tunidesign.utilisateurservice.DTO.ClientRequestDTO;
import com.tunidesign.utilisateurservice.DTO.ClientResponseDTO;
import com.tunidesign.utilisateurservice.DTO.CompanyUserRequestDTO;
import com.tunidesign.utilisateurservice.DTO.CompanyUserResponseDTO;
import com.tunidesign.utilisateurservice.DTO.InsuranceUserRequestDTO;
import com.tunidesign.utilisateurservice.DTO.InsuranceUserResponseDTO;
import com.tunidesign.utilisateurservice.DTO.UserRequestDTO;
import com.tunidesign.utilisateurservice.DTO.UserResponseDTO;
import com.tunidesign.utilisateurservice.model.entity.User;

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
