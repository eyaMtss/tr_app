package com.tunidesign.backendutilisateurmicroservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tunidesign.backendutilisateurmicroservice.DTO.PictureRequestDTO;
import com.tunidesign.backendutilisateurmicroservice.DTO.UserRequestDTO;
import com.tunidesign.backendutilisateurmicroservice.DTO.UserResponseDTO;
import com.tunidesign.backendutilisateurmicroservice.mapper.UserMapperImpl;
import com.tunidesign.backendutilisateurmicroservice.model.entity.User;
import com.tunidesign.backendutilisateurmicroservice.model.enumeration.Role;
import com.tunidesign.backendutilisateurmicroservice.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	private UserMapperImpl userMapper = new UserMapperImpl();

	@Override
	public UserResponseDTO addUser(UserRequestDTO userRequestDTO) {
		return userMapper.userToUserResponseDTO(userRepository.save(userMapper.userRequestDTOToUser(userRequestDTO)));
	}

	@Override
	public UserResponseDTO addClient(UserRequestDTO userRequestDTO) {
		userRequestDTO.setRole(Role.CLEINT);
		return addUser(userRequestDTO);
	}

	@Override
	public UserResponseDTO addTA(UserRequestDTO userRequestDTO) {
		userRequestDTO.setRole(Role.TA);
		return addUser(userRequestDTO);
	}

	@Override
	public UserResponseDTO addDriver(UserRequestDTO userRequestDTO) {
		userRequestDTO.setRole(Role.DRIVER);
		return addUser(userRequestDTO);
	}

	@Override
	public UserResponseDTO addExpert(UserRequestDTO userRequestDTO) {
		userRequestDTO.setRole(Role.EXPERT);
		return addUser(userRequestDTO);
	}

	@Override
	public UserResponseDTO addCompanyAdmin(UserRequestDTO userRequestDTO) {
		userRequestDTO.setRole(Role.COMPANY_ADMIN);
		return addUser(userRequestDTO);
	}

	@Override
	public UserResponseDTO addAgencyAdmin(UserRequestDTO userRequestDTO) {
		userRequestDTO.setRole(Role.AGENCY_ADMIN);
		return addUser(userRequestDTO);
	}

	@Override
	public UserResponseDTO addInsuranceAdmin(UserRequestDTO userRequestDTO) {
		userRequestDTO.setRole(Role.INSURANCE_ADMIN);
		return addUser(userRequestDTO);
	}

	@Override
	public UserResponseDTO addPrestataire(UserRequestDTO userRequestDTO) {
		userRequestDTO.setRole(Role.PRESTATAIRE);
		return addUser(userRequestDTO);
	}

	@Override
	public UserResponseDTO uploadPicture(PictureRequestDTO pictureRequestDTO) {
		User existingUser = userRepository.findById(pictureRequestDTO.getUserId()).get();
		existingUser.setPictureName(pictureRequestDTO.getPictureName());
		existingUser.setPictureType(pictureRequestDTO.getPictureType());
		existingUser.setPictureByte(pictureRequestDTO.getPictureByte());
		return userMapper.userToUserResponseDTO(userRepository.save(existingUser));
	}

	@Override
	public UserResponseDTO updateUser(UserRequestDTO userRequestDTO) {
		// User existingUser =
		// userRepository.findById(userRequestDTO.getUserId()).get();
		User user = userMapper.userRequestDTOToUser(userRequestDTO);
		User savedUser = userRepository.save(user);
		return userMapper.userToUserResponseDTO(savedUser);
	}

	@Override
	public List<UserResponseDTO> getUsers() {
		return userRepository.findAll().stream().map(user -> userMapper.userToUserResponseDTO(user)).toList();
	}

	@Override
	public UserResponseDTO getUser(Long userId) {
		return userMapper.userToUserResponseDTO(userRepository.findById(userId).get());
	}

	@Override
	public void deleteUser(Long userId) {
		userRepository.deleteById(userId);

	}

	@Override
	public Boolean isExist(Long userId) {
		return userRepository.findById(userId).isPresent();
	}

	@Override
	public List<UserResponseDTO> getClients() {
		return userRepository.findByRole(Role.CLEINT).stream().map(user -> userMapper.userToUserResponseDTO(user))
				.toList();
	}

	@Override
	public List<UserResponseDTO> getDrivers(Long companyId) {
		return userRepository.findCompanyEmployeesByRole(companyId, Role.DRIVER).stream()
				.map(user -> userMapper.userToUserResponseDTO(user)).toList();
	}

	@Override
	public List<UserResponseDTO> getTAs(Long companyId) {
		return userRepository.findCompanyEmployeesByRole(companyId, Role.TA).stream()
				.map(user -> userMapper.userToUserResponseDTO(user)).toList();
	}

	@Override
	public List<UserResponseDTO> getExperts(Long companyId) {
		return userRepository.findCompanyEmployeesByRole(companyId, Role.EXPERT).stream()
				.map(user -> userMapper.userToUserResponseDTO(user)).toList();
	}

	@Override
	public List<UserResponseDTO> getCompanyEmployees(Long companyId) {
		return userRepository.findByCompanyId(companyId).stream().map(user -> userMapper.userToUserResponseDTO(user))
				.toList();
	}

	@Override
	public List<UserResponseDTO> getAgencyEmployees(Long agencyId) {
		return userRepository.findByAgencyId(agencyId).stream().map(user -> userMapper.userToUserResponseDTO(user))
				.toList();
	}

	@Override
	public List<UserResponseDTO> getInsuranceEmployees(Long insuranceId) {
		return userRepository.findByInsuranceCompanyId(insuranceId).stream()
				.map(user -> userMapper.userToUserResponseDTO(user)).toList();
	}

}
