package com.tunidesign.utilisateurmicroservice.mapper;

import com.tunidesign.utilisateurmicroservice.DTO.*;
import com.tunidesign.utilisateurmicroservice.model.entity.User;

public interface UserMapper {
	UserResponseDTO userToUserResponseDTO(User user);
	User userRequestDTOToUser(UserRequestDTO userRequestDTO);
	User updatedUserRequestDTOToUser(UpdatedUserRequestDTO updatedUserRequestDTO);
	
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
