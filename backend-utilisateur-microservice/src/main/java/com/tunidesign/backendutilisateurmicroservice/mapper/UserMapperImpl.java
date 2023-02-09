package com.tunidesign.backendutilisateurmicroservice.mapper;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

import com.tunidesign.backendutilisateurmicroservice.DTO.UserRequestDTO;
import com.tunidesign.backendutilisateurmicroservice.DTO.UserResponseDTO;
import com.tunidesign.backendutilisateurmicroservice.model.entity.User;

public class UserMapperImpl implements UserMapper {

	// private final Builder webClientBuilder;
	@Override
	public UserResponseDTO userToUserResponseDTO(User user) {
		if (user == null) {
			return null;
		}
		UserResponseDTO userResponseDTO = new UserResponseDTO();
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
		user.setRole(userRequestDTO.getRole());
		return user;
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
