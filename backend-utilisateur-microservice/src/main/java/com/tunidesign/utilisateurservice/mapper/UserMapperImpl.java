package com.tunidesign.utilisateurservice.mapper;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

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

public class UserMapperImpl implements UserMapper {

	// private final Builder webClientBuilder;
	@Override
	public UserResponseDTO userToUserResponseDTO(User user) {
		if (user == null) {
			return null;
		}
		UserResponseDTO userResponseDTO = new UserResponseDTO();
		userResponseDTO.setUserId(user.getUserId());
		userResponseDTO.setFirstname(user.getFirstname());
		userResponseDTO.setLastname(user.getLastname());
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
		//userResponseDTO.setPictureByte(decompressBytes(user.getPictureByte()));
		userResponseDTO.setAgencyId(user.getAgencyId());
		userResponseDTO.setInsuranceCompanyId(user.getInsuranceCompanyId());
		userResponseDTO.setCompanyId(user.getCompanyId());
		return userResponseDTO;
	}

	@Override
	public User userRequestDTOToUser(UserRequestDTO userRequestDTO) {
		if (userRequestDTO == null) {
			return null;
		}
		User user = new User();
		user.setUserId(userRequestDTO.getUserId());
		user.setFirstname(userRequestDTO.getFirstname());
		user.setLastname(userRequestDTO.getLastname());
		user.setGender(userRequestDTO.getGender());
		user.setBirthdate(userRequestDTO.getBirthdate());
		user.setCountry(userRequestDTO.getCountry());
		user.setGovernorate(userRequestDTO.getGovernorate());
		user.setCity(userRequestDTO.getCity());
		user.setZipCode(userRequestDTO.getZipCode());
		user.setHomeCode(userRequestDTO.getHomeCode());
		user.setEmail(userRequestDTO.getEmail());
		user.setPhoneNumber(userRequestDTO.getPhoneNumber());
		user.setAgencyId(userRequestDTO.getAgencyId());
		user.setInsuranceCompanyId(userRequestDTO.getInsuranceCompanyId());
		user.setCompanyId(userRequestDTO.getCompanyId());
		user.setLogin(userRequestDTO.getLogin());
		user.setPassword(userRequestDTO.getPassword());
		user.setConfirmPassword(userRequestDTO.getConfirmPassword());
		return user;
	}

	@Override
	public ClientResponseDTO userToClientResponseDTO(User user) {
		if (user == null) {
			return null;
		}
		ClientResponseDTO clientResponseDTO = new ClientResponseDTO();
		clientResponseDTO.setUserId(user.getUserId());
		clientResponseDTO.setFirstname(user.getFirstname());
		clientResponseDTO.setLastname(user.getLastname());
		clientResponseDTO.setGender(user.getGender());
		clientResponseDTO.setBirthdate(user.getBirthdate());
		clientResponseDTO.setCountry(user.getCountry());
		clientResponseDTO.setGovernorate(user.getGovernorate());
		clientResponseDTO.setCity(user.getCity());
		clientResponseDTO.setZipCode(user.getZipCode());
		clientResponseDTO.setHomeCode(user.getHomeCode());
		clientResponseDTO.setEmail(user.getEmail());
		clientResponseDTO.setPhoneNumber(user.getPhoneNumber());
		clientResponseDTO.setPictureName(user.getPictureName());
		//clientResponseDTO.setPictureByte(decompressBytes(user.getPictureByte()));
		return clientResponseDTO;
	}

	@Override
	public User clientRequestDTOToUser(ClientRequestDTO clientRequestDTO) {
		if (clientRequestDTO == null) {
			return null;
		}
		User user = new User();
		user.setUserId(clientRequestDTO.getUserId());
		user.setFirstname(clientRequestDTO.getFirstname());
		user.setLastname(clientRequestDTO.getLastname());
		user.setGender(clientRequestDTO.getGender());
		user.setBirthdate(clientRequestDTO.getBirthdate());
		user.setCountry(clientRequestDTO.getCountry());
		user.setGovernorate(clientRequestDTO.getGovernorate());
		user.setCity(clientRequestDTO.getCity());
		user.setZipCode(clientRequestDTO.getZipCode());
		user.setHomeCode(clientRequestDTO.getHomeCode());
		user.setEmail(clientRequestDTO.getEmail());
		user.setPhoneNumber(clientRequestDTO.getPhoneNumber());
		user.setLogin(clientRequestDTO.getLogin());
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
		companyUsersResponseDTO.setFirstname(user.getFirstname());
		companyUsersResponseDTO.setLastname(user.getLastname());
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
		companyUsersResponseDTO.setCompanyId(user.getCompanyId());
		
//		if (user.getPictureByte().equals(null)) companyUsersResponseDTO.setPictureByte(null);
//		else companyUsersResponseDTO.setPictureByte(decompressBytes(user.getPictureByte()));
		return companyUsersResponseDTO;
	}

	@Override
	public User companyUserRequestDTOToUser(CompanyUserRequestDTO companyUserRequestDTO) {
		if (companyUserRequestDTO == null) {
			return null;
		}
		User user = new User();
		user.setUserId(companyUserRequestDTO.getUserId());
		user.setFirstname(companyUserRequestDTO.getFirstname());
		user.setLastname(companyUserRequestDTO.getLastname());
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
		user.setCompanyId(companyUserRequestDTO.getCompanyId());
		user.setInsuranceCompanyId(null);
		user.setAgencyId(null);
		user.setLogin(companyUserRequestDTO.getLogin());
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
		agencyUserResponseDTO.setFirstname(user.getFirstname());
		agencyUserResponseDTO.setLastname(user.getLastname());
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
		//agencyUserResponseDTO.setPictureByte(decompressBytes(user.getPictureByte()));
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
		user.setFirstname(agencyUserRequestDto.getFirstname());
		user.setLastname(agencyUserRequestDto.getLastname());
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
		user.setCompanyId(agencyUserRequestDto.getAgencyId());
		user.setLogin(agencyUserRequestDto.getLogin());
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
		insuranceUserResponseDTO.setFirstname(user.getFirstname());
		insuranceUserResponseDTO.setLastname(user.getLastname());
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
		//insuranceUserResponseDTO.setPictureByte(decompressBytes(user.getPictureByte()));
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
		user.setFirstname(insuranceUserRequestDto.getFirstname());
		user.setLastname(insuranceUserRequestDto.getLastname());
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
		user.setCompanyId(insuranceUserRequestDto.getInsuranceCompanyId());
		user.setLogin(insuranceUserRequestDto.getLogin());
		user.setPassword(insuranceUserRequestDto.getPassword());
		user.setConfirmPassword(insuranceUserRequestDto.getConfirmPassword());
		return user;
	}
	
	@Override
	public AuthenticationResponseDTO userToAuthenticationResponseDTO(User user) {
		if (user == null) {
			return null;
		}
		AuthenticationResponseDTO authenticationResponseDTO = new AuthenticationResponseDTO();
		authenticationResponseDTO.setLogin(user.getLogin());
		authenticationResponseDTO.setRole(user.getRole());
		return authenticationResponseDTO;
	}
	
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

}
