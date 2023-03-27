package com.tunidesign.utilisateurmicroservice.service;

import java.nio.CharBuffer;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.tunidesign.utilisateurmicroservice.DTO.AgencyUserResponseDTO;
import com.tunidesign.utilisateurmicroservice.DTO.ClientResponseDTO;
import com.tunidesign.utilisateurmicroservice.DTO.CompanyUserResponseDTO;
import com.tunidesign.utilisateurmicroservice.DTO.InsuranceUserResponseDTO;
import com.tunidesign.utilisateurmicroservice.DTO.PictureRequestDTO;
import com.tunidesign.utilisateurmicroservice.DTO.UserResponseDTO;
import com.tunidesign.utilisateurmicroservice.mapper.UserMapperImpl;
import com.tunidesign.utilisateurmicroservice.model.entity.User;
import com.tunidesign.utilisateurmicroservice.model.enumeration.Role;
import com.tunidesign.utilisateurmicroservice.model.enumeration.Status;
import com.tunidesign.utilisateurmicroservice.repository.UserRepository;

import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	private UserMapperImpl userMapper = new UserMapperImpl();
	@Autowired
	private PasswordEncoder passwordEncoder;
	private static final int keyLength = 256;
	public boolean isPasswordsMatched(String givenPassword, String existedPassword) {
		if (passwordEncoder.matches(CharBuffer.wrap(givenPassword), existedPassword)) 
			return true;
		return false;
		
	}
	@Override
	public User addUser(User user) throws NoSuchAlgorithmException, InvalidKeySpecException {
		//user.setPassword(passwordEncoder.encode(user.getPassword()));
		//user = addUserCredentials(user);
		return userRepository.save(user);
	}

	@Override
	public User updateRole(Long userId, Role role) {
		User savedUser = getUser(userId);
		savedUser.setRole(role);
		return userRepository.save(savedUser);
	}

	@Override
	public User getUser(Long userId) {
		return userRepository.findById(userId).get();
	}

	@Override
	public User uploadPicture(PictureRequestDTO pictureRequestDTO) {
		User existingUser = userRepository.findById(pictureRequestDTO.getUserId()).get();
		existingUser.setPictureName(pictureRequestDTO.getPictureName());
		existingUser.setPictureType(pictureRequestDTO.getPictureType());
		existingUser.setPictureByte(pictureRequestDTO.getPictureByte());
		return userRepository.save(existingUser);
	}

	@Override
	public User updateUser(User user) {
		User savedUser = userRepository.save(user);
		return savedUser;
	}

	@Override
	public User changeStatus(Long userId, Status status) {
		User existingUser = userRepository.findById(userId).get();
		existingUser.setStatus(status);
		return existingUser;
	}



	@Override
	public List<UserResponseDTO> getUsers() {
		return userRepository.findAll().stream().map(user -> userMapper.userToUserResponseDTO(user)).toList();
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
	public List<ClientResponseDTO> getClients() {
		return userRepository.findByRole(Role.CLEINT).stream().map(user -> userMapper.userToClientResponseDTO(user))
				.toList();
	}

	@Override
	public List<CompanyUserResponseDTO> getDrivers(Long companyId) {
		return userRepository.findCompanyEmployeesByRole(companyId, Role.DRIVER).stream()
				.map(user -> userMapper.userToCompanyUserResponseDTO(user)).toList();
	}

	@Override
	public List<CompanyUserResponseDTO> getTAs(Long companyId) {
		return userRepository.findCompanyEmployeesByRole(companyId, Role.TA).stream()
				.map(user -> userMapper.userToCompanyUserResponseDTO(user)).toList();
	}

	@Override
	public List<CompanyUserResponseDTO> getCompanyAdmins(Long companyId) {
		return userRepository.findCompanyEmployeesByRole(companyId, Role.COMPANY_ADMIN).stream()
				.map(user -> userMapper.userToCompanyUserResponseDTO(user)).toList();
	}

	@Override
	public List<CompanyUserResponseDTO> getCompanyEmployees(Long companyId) {
		return userRepository.findBySocieteRemorquageId(companyId).stream()
				.map(user -> userMapper.userToCompanyUserResponseDTO(user)).toList();
	}

	@Override
	public List<AgencyUserResponseDTO> getAgencyAdmins(Long agencyId) {
		return userRepository.findAgencyEmployeesByRole(agencyId, Role.AGENCY_ADMIN).stream()
				.map(user -> userMapper.userToAgencyUserResponseDTO(user)).toList();
	}

	@Override
	public List<AgencyUserResponseDTO> getAgencyEmployees(Long agencyId) {
		return userRepository.findByAgencyId(agencyId).stream()
				.map(user -> userMapper.userToAgencyUserResponseDTO(user)).toList();
	}

	@Override
	public List<InsuranceUserResponseDTO> getExperts(Long insuranceId) {
		return userRepository.findInsuranceEmployeesByRole(insuranceId, Role.EXPERT).stream()
				.map(user -> userMapper.userToInsuranceUserResponseDTO(user)).toList();
	}

	@Override
	public List<InsuranceUserResponseDTO> getInsuranceAdmins(Long insuranceId) {
		return userRepository.findInsuranceEmployeesByRole(insuranceId, Role.INSURANCE_ADMIN).stream()
				.map(user -> userMapper.userToInsuranceUserResponseDTO(user)).toList();
	}

	@Override
	public List<InsuranceUserResponseDTO> getInsuranceEmployees(Long insuranceId) {
		return userRepository.findByInsuranceCompanyId(insuranceId).stream()
				.map(user -> userMapper.userToInsuranceUserResponseDTO(user)).toList();
	}

	@Override
	public User getUserByUsernameOrEmail(String identifier) {
		User existingUser = userRepository.findByUsernameOrEmail(identifier, identifier);
		/*if (existingUser != null && existingUser.getPassword().equals(password)) {
			return userMapper.userToAuthenticationResponseDTO(existingUser);
		}*/
		return existingUser;
	}

	@Override
	public Optional<User> getUserByEmail(String email) {
		return Optional.ofNullable(userRepository.findByEmail(email));
	}

	@Override
	public Optional<User> getUserByUsername(String login) {
		return Optional.ofNullable(userRepository.findByUsername(login));
	}

	@Override
	public User updateCompletedRegistration(String username) {
		User existingUser = userRepository.findByUsername(username);
		existingUser.setCompletedRegistration(true);
		return userRepository.save(existingUser);
	}

	public User addUserCredentials(User user) throws NoSuchAlgorithmException, InvalidKeySpecException {
		// Generate a salt for the password
		byte[] salt = generateSalt();
		String hashedPassword = hashPassword(user.getPassword(), salt);
		// hash password
		user.setPassword(String.valueOf(hashedPassword));
		// code to store the salt and hashed password in the database
		user.setConfirmPassword(String.valueOf(hashedPassword));
		user.setSalt(salt);
		return user;
	}

	private String hashPassword(String password, byte[] salt){


		int iterations = 10000;
		try {
			SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
			PBEKeySpec spec = new PBEKeySpec(password.toCharArray(), salt, iterations, keyLength);
			SecretKey key = skf.generateSecret(spec);
			return Base64.getEncoder().encodeToString(key.getEncoded());
		} catch (Exception e) {
			return "";
		}
	}
	private byte[] generateSalt() {
		// Generate a random salt for the password
		SecureRandom random = new SecureRandom();
		byte[] salt = new byte[16];
		random.nextBytes(salt);
		return salt;
	}
}
