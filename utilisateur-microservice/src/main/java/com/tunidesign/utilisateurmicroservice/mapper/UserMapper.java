package com.tunidesign.utilisateurmicroservice.mapper;

import com.tunidesign.utilisateurmicroservice.DTO.AgencyUserRequestDTO;
import com.tunidesign.utilisateurmicroservice.DTO.AgencyUserResponseDTO;
import com.tunidesign.utilisateurmicroservice.DTO.AuthenticationResponseDTO;
import com.tunidesign.utilisateurmicroservice.DTO.ClientRequestDTO;
import com.tunidesign.utilisateurmicroservice.DTO.ClientResponseDTO;
import com.tunidesign.utilisateurmicroservice.DTO.CompanyUserRequestDTO;
import com.tunidesign.utilisateurmicroservice.DTO.CompanyUserResponseDTO;
import com.tunidesign.utilisateurmicroservice.DTO.InsuranceUserRequestDTO;
import com.tunidesign.utilisateurmicroservice.DTO.InsuranceUserResponseDTO;
import com.tunidesign.utilisateurmicroservice.DTO.UserRequestDTO;
import com.tunidesign.utilisateurmicroservice.DTO.UserResponseDTO;
import com.tunidesign.utilisateurmicroservice.model.entity.User;

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
