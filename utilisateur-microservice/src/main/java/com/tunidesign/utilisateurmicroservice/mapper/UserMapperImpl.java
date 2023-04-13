package com.tunidesign.utilisateurmicroservice.mapper;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

import com.tunidesign.utilisateurmicroservice.DTO.*;
import com.tunidesign.utilisateurmicroservice.model.entity.User;

public class UserMapperImpl implements UserMapper {
	@Override
	public UserResponseDTO userToUserResponseDTO(User user) {
		if (user == null) {
			return null;
		}
		UserResponseDTO userResponseDTO = new UserResponseDTO();
		userResponseDTO.setUserId(user.getUserId());
		userResponseDTO.setFirstName(user.getFirstName());
		userResponseDTO.setLastName(user.getLastName());
		userResponseDTO.setGender(user.getGender());
		userResponseDTO.setBirthdate(user.getBirthdate());
		userResponseDTO.setCountry(user.getCountry());
		userResponseDTO.setGovernorate(user.getGovernorate());
		userResponseDTO.setCity(user.getCity());
		userResponseDTO.setZipCode(user.getZipCode());
		userResponseDTO.setHomeCode(user.getHomeCode());
		userResponseDTO.setEmail(user.getEmail());
		userResponseDTO.setPhoneNumber(user.getPhoneNumber());
		userResponseDTO.setPictureName(user.getPictureName());
		userResponseDTO.setIsRegistrationCompleted(user.getIsRegistrationCompleted());
		return userResponseDTO;
	}

	@Override
	public User userRequestDTOToUser(UserRequestDTO userRequestDTO) {
		if (userRequestDTO == null) {
			return null;
		}
		return User.builder()
				.firstName(userRequestDTO.getFirstName())
				.lastName(userRequestDTO.getLastName())
				.username(userRequestDTO.getUsername())
				.email(userRequestDTO.getEmail())
				.birthdate(userRequestDTO.getBirthdate())
				.gender(userRequestDTO.getGender())
				.phoneNumber(userRequestDTO.getPhoneNumber())
				.countryCode(userRequestDTO.getCountryCode())
				.dialCode(userRequestDTO.getDialCode())
				.password(userRequestDTO.getPassword())
				.confirmPassword(userRequestDTO.getConfirmPassword())
				.societeLocationId(userRequestDTO.getSocieteLocationId())
				.societeRemorquageId(userRequestDTO.getSocieteRemorquageId())
				.insuranceCompanyId(userRequestDTO.getInsuranceCompanyId())
				.role(userRequestDTO.getRole())
				.build();
	}

	/**
	 * Eya Mattoussi
	 * 28/03/2023
	 * while completing registration (address && matriculeFiscale) if the user is not a CLIENT
	 * @param updatedUserRequestDTO
	 * @return user
	 */
	@Override
	public User updatedUserRequestDTOToUser(UpdatedUserRequestDTO updatedUserRequestDTO) {
		return User.builder()
				.username(updatedUserRequestDTO.getUsername())
				.country(updatedUserRequestDTO.getCountry())
				.governorate(updatedUserRequestDTO.getGovernorate())
				.city(updatedUserRequestDTO.getCity())
				.zipCode(updatedUserRequestDTO.getZipCode())
				.matriculeFiscale(updatedUserRequestDTO.getMatriculeFiscale())
				.cin(updatedUserRequestDTO.getCin())
				.build();
	}

	@Override
	public ClientResponseDTO userToClientResponseDTO(User user) {
		if (user == null) {
			return null;
		}
		ClientResponseDTO clientResponseDTO = new ClientResponseDTO();
		clientResponseDTO.setUserId(user.getUserId());
		clientResponseDTO.setFirstName(user.getFirstName());
		clientResponseDTO.setLastName(user.getLastName());
		clientResponseDTO.setGender(user.getGender());
		clientResponseDTO.setBirthdate(user.getBirthdate());
		clientResponseDTO.setCountry(user.getCountry());
		clientResponseDTO.setGovernorate(user.getGovernorate());
		clientResponseDTO.setCity(user.getCity());
		clientResponseDTO.setZipCode(user.getZipCode());
		clientResponseDTO.setHomeCode(user.getHomeCode());
		clientResponseDTO.setEmail(user.getEmail());
		clientResponseDTO.setPhoneNumber(user.getPhoneNumber());
		clientResponseDTO.setCompletedRegistration(user.getCompletedRegistration());
		return clientResponseDTO;
	}

	@Override
	public User clientRequestDTOToUser(ClientRequestDTO clientRequestDTO) {
		if (clientRequestDTO == null) {
			return null;
		}
		User user = new User();
		user.setFirstName(clientRequestDTO.getFirstName());
		user.setLastName(clientRequestDTO.getLastName());
		user.setGender(clientRequestDTO.getGender());
		user.setBirthdate(clientRequestDTO.getBirthdate());
		user.setCountry(clientRequestDTO.getCountry());
		user.setGovernorate(clientRequestDTO.getGovernorate());
		user.setCity(clientRequestDTO.getCity());
		user.setZipCode(clientRequestDTO.getZipCode());
		//user.setHomeCode(clientRequestDTO.getHomeCode());
		user.setEmail(clientRequestDTO.getEmail());
		user.setPhoneNumber(clientRequestDTO.getPhoneNumber());
		user.setPassword(clientRequestDTO.getPassword());
		user.setConfirmPassword(clientRequestDTO.getConfirmPassword());
		return user;
	}

	@Override
	public CompanyUserResponseDTO userToCompanyUserResponseDTO(User user) {
		if (user == null) {
			return null;
		}
		CompanyUserResponseDTO companyUsersResponseDTO = new CompanyUserResponseDTO();
		companyUsersResponseDTO.setUserId(user.getUserId());
		companyUsersResponseDTO.setFirstName(user.getFirstName());
		companyUsersResponseDTO.setLastName(user.getLastName());
		companyUsersResponseDTO.setGender(user.getGender());
		companyUsersResponseDTO.setBirthdate(user.getBirthdate());
		companyUsersResponseDTO.setCountry(user.getCountry());
		companyUsersResponseDTO.setGovernorate(user.getGovernorate());
		companyUsersResponseDTO.setCity(user.getCity());
		companyUsersResponseDTO.setZipCode(user.getZipCode());
		companyUsersResponseDTO.setHomeCode(user.getHomeCode());
		companyUsersResponseDTO.setEmail(user.getEmail());
		companyUsersResponseDTO.setPhoneNumber(user.getPhoneNumber());
		companyUsersResponseDTO.setPictureName(user.getPictureName());
		companyUsersResponseDTO.setMatriculeFiscale(user.getMatriculeFiscale());
		companyUsersResponseDTO.setStatus(user.getStatus());
		companyUsersResponseDTO.setCompanyId(user.getSocieteRemorquageId());
		return companyUsersResponseDTO;
	}

	@Override
	public User companyUserRequestDTOToUser(CompanyUserRequestDTO companyUserRequestDTO) {
		if (companyUserRequestDTO == null) {
			return null;
		}
		User user = new User();
		user.setUserId(companyUserRequestDTO.getUserId());
		user.setFirstName(companyUserRequestDTO.getFirstName());
		user.setLastName(companyUserRequestDTO.getLastName());
		user.setGender(companyUserRequestDTO.getGender());
		user.setBirthdate(companyUserRequestDTO.getBirthdate());
		user.setCountry(companyUserRequestDTO.getCountry());
		user.setGovernorate(companyUserRequestDTO.getGovernorate());
		user.setCity(companyUserRequestDTO.getCity());
		user.setZipCode(companyUserRequestDTO.getZipCode());
		user.setHomeCode(companyUserRequestDTO.getHomeCode());
		user.setEmail(companyUserRequestDTO.getEmail());
		user.setPhoneNumber(companyUserRequestDTO.getPhoneNumber());
		user.setMatriculeFiscale(companyUserRequestDTO.getMatriculeFiscale());
		user.setStatus(companyUserRequestDTO.getStatus());
		user.setSocieteRemorquageId(companyUserRequestDTO.getSocieteRemorquageId());
		user.setInsuranceCompanyId(null);
		user.setAgencyId(null);
		user.setUsername(companyUserRequestDTO.getUsername());
		user.setPassword(companyUserRequestDTO.getPassword());
		user.setConfirmPassword(companyUserRequestDTO.getConfirmPassword());
		return user;
	}

	@Override
	public AgencyUserResponseDTO userToAgencyUserResponseDTO(User user) {
		if (user == null) {
			return null;
		}
		AgencyUserResponseDTO agencyUserResponseDTO = new AgencyUserResponseDTO();
		agencyUserResponseDTO.setUserId(user.getUserId());
		agencyUserResponseDTO.setFirstName(user.getFirstName());
		agencyUserResponseDTO.setLastName(user.getLastName());
		agencyUserResponseDTO.setGender(user.getGender());
		agencyUserResponseDTO.setBirthdate(user.getBirthdate());
		agencyUserResponseDTO.setCountry(user.getCountry());
		agencyUserResponseDTO.setGovernorate(user.getGovernorate());
		agencyUserResponseDTO.setCity(user.getCity());
		agencyUserResponseDTO.setZipCode(user.getZipCode());
		agencyUserResponseDTO.setHomeCode(user.getHomeCode());
		agencyUserResponseDTO.setEmail(user.getEmail());
		agencyUserResponseDTO.setPhoneNumber(user.getPhoneNumber());
		agencyUserResponseDTO.setMatriculeFiscale(user.getMatriculeFiscale());
		agencyUserResponseDTO.setStatus(user.getStatus());
		agencyUserResponseDTO.setPictureName(user.getPictureName());
		agencyUserResponseDTO.setAgencyId(user.getAgencyId());
		return agencyUserResponseDTO;
	}

	@Override
	public User agencyUserRequestDTOToUser(AgencyUserRequestDTO agencyUserRequestDto) {
		if (agencyUserRequestDto == null) {
			return null;
		}
		User user = new User();
		user.setUserId(agencyUserRequestDto.getUserId());
		user.setFirstName(agencyUserRequestDto.getFirstName());
		user.setLastName(agencyUserRequestDto.getLastName());
		user.setGender(agencyUserRequestDto.getGender());
		user.setBirthdate(agencyUserRequestDto.getBirthdate());
		user.setCountry(agencyUserRequestDto.getCountry());
		user.setGovernorate(agencyUserRequestDto.getGovernorate());
		user.setCity(agencyUserRequestDto.getCity());
		user.setZipCode(agencyUserRequestDto.getZipCode());
		user.setHomeCode(agencyUserRequestDto.getHomeCode());
		user.setEmail(agencyUserRequestDto.getEmail());
		user.setPhoneNumber(agencyUserRequestDto.getPhoneNumber());
		user.setMatriculeFiscale(agencyUserRequestDto.getMatriculeFiscale());
		user.setStatus(agencyUserRequestDto.getStatus());
		user.setSocieteRemorquageId(agencyUserRequestDto.getAgencyId());
		user.setUsername(agencyUserRequestDto.getUsername());
		user.setPassword(agencyUserRequestDto.getPassword());
		user.setConfirmPassword(agencyUserRequestDto.getConfirmPassword());
		return user;
	}


	@Override
	public InsuranceUserResponseDTO userToInsuranceUserResponseDTO(User user) {
		if (user == null) {
			return null;
		}
		InsuranceUserResponseDTO insuranceUserResponseDTO = new InsuranceUserResponseDTO();
		insuranceUserResponseDTO.setUserId(user.getUserId());
		insuranceUserResponseDTO.setFirstName(user.getFirstName());
		insuranceUserResponseDTO.setLastName(user.getLastName());
		insuranceUserResponseDTO.setGender(user.getGender());
		insuranceUserResponseDTO.setBirthdate(user.getBirthdate());
		insuranceUserResponseDTO.setCountry(user.getCountry());
		insuranceUserResponseDTO.setGovernorate(user.getGovernorate());
		insuranceUserResponseDTO.setCity(user.getCity());
		insuranceUserResponseDTO.setZipCode(user.getZipCode());
		insuranceUserResponseDTO.setHomeCode(user.getHomeCode());
		insuranceUserResponseDTO.setEmail(user.getEmail());
		insuranceUserResponseDTO.setPhoneNumber(user.getPhoneNumber());
		insuranceUserResponseDTO.setPictureName(user.getPictureName());
		insuranceUserResponseDTO.setMatriculeFiscale(user.getMatriculeFiscale());
		insuranceUserResponseDTO.setStatus(user.getStatus());
		insuranceUserResponseDTO.setInsuranceCompanyId(user.getInsuranceCompanyId());
		return insuranceUserResponseDTO;
	}

	@Override
	public User insuranceUserRequestDTOToUser(InsuranceUserRequestDTO insuranceUserRequestDto) {
		if (insuranceUserRequestDto == null) {
			return null;
		}
		User user = new User();
		user.setUserId(insuranceUserRequestDto.getUserId());
		user.setFirstName(insuranceUserRequestDto.getFirstName());
		user.setLastName(insuranceUserRequestDto.getLastName());
		user.setGender(insuranceUserRequestDto.getGender());
		user.setBirthdate(insuranceUserRequestDto.getBirthdate());
		user.setCountry(insuranceUserRequestDto.getCountry());
		user.setGovernorate(insuranceUserRequestDto.getGovernorate());
		user.setCity(insuranceUserRequestDto.getCity());
		user.setZipCode(insuranceUserRequestDto.getZipCode());
		user.setHomeCode(insuranceUserRequestDto.getHomeCode());
		user.setEmail(insuranceUserRequestDto.getEmail());
		user.setPhoneNumber(insuranceUserRequestDto.getPhoneNumber());
		user.setMatriculeFiscale(insuranceUserRequestDto.getMatriculeFiscale());
		user.setStatus(insuranceUserRequestDto.getStatus());
		user.setSocieteRemorquageId(insuranceUserRequestDto.getInsuranceCompanyId());
		user.setUsername(insuranceUserRequestDto.getUsername());
		user.setPassword(insuranceUserRequestDto.getPassword());
		user.setConfirmPassword(insuranceUserRequestDto.getConfirmPassword());
		return user;
	}
	
//	@Override
//	public AuthenticationResponseDTO userToAuthenticationResponseDTO(User user) {
//		if (user == null) {
//			return null;
//		}
//		AuthenticationResponseDTO authenticationResponseDTO = new AuthenticationResponseDTO();
//		authenticationResponseDTO.setUsername(user.getUsername());
//		authenticationResponseDTO.setRole(user.getRole());
//		return authenticationResponseDTO;
//	}
	
	// uncompress the image bytes before returning it to the angular application
	public static byte[] decompressBytes(byte[] data) {
		Inflater inflater = new Inflater();
		inflater.setInput(data);
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
		byte[] buffer = new byte[1024];
		try {
			while (!inflater.finished()) {
				int count = inflater.inflate(buffer);
				outputStream.write(buffer, 0, count);
			}
			outputStream.close();
		} catch (IOException ioe) {
		} catch (DataFormatException e) {
		}
		return outputStream.toByteArray();
	}

	@Override
	public AuthenticationResponseDTO userToAuthenticationResponseDTO(User user) {
		// TODO Auto-generated method stub
		return null;
	}

}
