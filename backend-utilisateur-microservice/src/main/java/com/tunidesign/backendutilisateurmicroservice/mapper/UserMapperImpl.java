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
		UserResponseDTO.builder()
				.firstname(user.getFirstname())
				.lastname(user.getLastname())
				.gender(user.getGender())
				.birthdate(user.getBirthdate())
				.country(user.getCountry())
				.governorate(user.getGovernorate())
				.city(user.getCity())
				.zipCode(user.getZipCode())
				.homeCode(user.getHomeCode()).email(user.getEmail())
				.phoneNumber(user.getPhoneNumber())
				.pictureName(user.getPictureName())
				.pictureType(user.getPictureType())
				.pictureByte(decompressBytes(user.getPictureByte()))
				.agencyId(user.getAgencyId())
				.insuranceCompanyId(user.getInsuranceCompanyId()).companyId(user.getCompanyId()).build();
		return userResponseDTO;
	}

	@Override
	public User userRequestDTOToUser(UserRequestDTO userRequestDTO) {
		if (userRequestDTO == null) {
			return null;
		}
		User user = new User();
		User.builder()
				.firstname(userRequestDTO.getFirstname())
				.lastname(userRequestDTO.getLastname())
				.gender(userRequestDTO.getGender())
				.birthdate(userRequestDTO.getBirthdate())
				.country(userRequestDTO.getCountry())
				.governorate(userRequestDTO.getGovernorate())
				.city(userRequestDTO.getCity())
				.zipCode(userRequestDTO.getZipCode())
				.homeCode(userRequestDTO.getHomeCode())
				.email(userRequestDTO.getEmail())
				.phoneNumber(userRequestDTO.getPhoneNumber())
				.agencyId(userRequestDTO.getAgencyId())
				.insuranceCompanyId(userRequestDTO.getInsuranceCompanyId())
				.companyId(userRequestDTO.getCompanyId())
				.build();
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
