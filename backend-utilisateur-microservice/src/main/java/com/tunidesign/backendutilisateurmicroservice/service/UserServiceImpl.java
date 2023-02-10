package com.tunidesign.backendutilisateurmicroservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tunidesign.backendutilisateurmicroservice.DTO.AgencyUserRequestDTO;
import com.tunidesign.backendutilisateurmicroservice.DTO.AgencyUserResponseDTO;
import com.tunidesign.backendutilisateurmicroservice.DTO.AuthenticationResponseDTO;
import com.tunidesign.backendutilisateurmicroservice.DTO.ClientRequestDTO;
import com.tunidesign.backendutilisateurmicroservice.DTO.ClientResponseDTO;
import com.tunidesign.backendutilisateurmicroservice.DTO.CompanyUserRequestDTO;
import com.tunidesign.backendutilisateurmicroservice.DTO.CompanyUserResponseDTO;
import com.tunidesign.backendutilisateurmicroservice.DTO.InsuranceUserRequestDTO;
import com.tunidesign.backendutilisateurmicroservice.DTO.InsuranceUserResponseDTO;
import com.tunidesign.backendutilisateurmicroservice.DTO.PictureRequestDTO;
import com.tunidesign.backendutilisateurmicroservice.DTO.UserRequestDTO;
import com.tunidesign.backendutilisateurmicroservice.DTO.UserResponseDTO;
import com.tunidesign.backendutilisateurmicroservice.mapper.UserMapperImpl;
import com.tunidesign.backendutilisateurmicroservice.model.entity.User;
import com.tunidesign.backendutilisateurmicroservice.model.enumeration.Role;
import com.tunidesign.backendutilisateurmicroservice.model.enumeration.Status;
import com.tunidesign.backendutilisateurmicroservice.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	private UserMapperImpl userMapper = new UserMapperImpl();

	@Override
	public UserResponseDTO addUser(User user) {
		return userMapper.userToUserResponseDTO(userRepository.save(user));
	}

	@Override
	public ClientResponseDTO addClient(ClientRequestDTO clientRequestDTO) {
		User user = userMapper.clientRequestDTOToUser(clientRequestDTO);
		user.setRole(Role.CLEINT);
		return userMapper.userToClientResponseDTO(userRepository.save(user));
	}

	@Override
	public CompanyUserResponseDTO addTA(CompanyUserRequestDTO taRequestDTO) {
		User user = userMapper.companyUserRequestDTOToUser(taRequestDTO);
		user.setRole(Role.TA);
		return userMapper.userToCompanyUserResponseDTO(userRepository.save(user));
	}

	@Override
	public CompanyUserResponseDTO addDriver(CompanyUserRequestDTO driverRequestDTO) {
		User user = userMapper.companyUserRequestDTOToUser(driverRequestDTO);
		user.setRole(Role.DRIVER);
		return userMapper.userToCompanyUserResponseDTO(userRepository.save(user));
	}

	@Override
	public CompanyUserResponseDTO addCompanyAdmin(CompanyUserRequestDTO adminRequestDTO) {
		User user = userMapper.companyUserRequestDTOToUser(adminRequestDTO);
		user.setRole(Role.COMPANY_ADMIN);
		return userMapper.userToCompanyUserResponseDTO(userRepository.save(user));
	}
	
	@Override
	public InsuranceUserResponseDTO addExpert(InsuranceUserRequestDTO expertRequestDTO) {
		User user = userMapper.insuranceUserRequestDTOToUser(expertRequestDTO);
		user.setRole(Role.EXPERT);
		return userMapper.userToInsuranceUserResponseDTO(userRepository.save(user));
	}

	@Override
	public AgencyUserResponseDTO addAgencyAdmin(AgencyUserRequestDTO adminRequestDTO) {
		User user = userMapper.agencyUserRequestDTOToUser(adminRequestDTO);
		user.setRole(Role.AGENCY_ADMIN);
		return userMapper.userToAgencyUserResponseDTO(userRepository.save(user));
	}

	@Override
	public InsuranceUserResponseDTO addInsuranceAdmin(InsuranceUserRequestDTO adminRequestDTO) {
		User user = userMapper.insuranceUserRequestDTOToUser(adminRequestDTO);
		user.setRole(Role.INSURANCE_ADMIN);
		return userMapper.userToInsuranceUserResponseDTO(userRepository.save(user));
	}

	@Override
	public UserResponseDTO addPrestataire(UserRequestDTO userRequestDTO) {
		User user = userMapper.userRequestDTOToUser(userRequestDTO);
		user.setRole(Role.PRESTATAIRE);
		return addUser(user);
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
		User user = userMapper.userRequestDTOToUser(userRequestDTO);
		User savedUser = userRepository.save(user);
		return userMapper.userToUserResponseDTO(savedUser);
	}

	@Override
	public User changeStatus(Long userId, Status status) {
		User existingUser = userRepository.findById(userId).get();
		existingUser.setStatus(status);
		return existingUser;
	}
	
	@Override
	public AgencyUserResponseDTO updateAgencyStatus(Long userId, Status status) {
		
		return userMapper.userToAgencyUserResponseDTO(userRepository.save(changeStatus(userId, status)));
	}

	@Override
	public CompanyUserResponseDTO updateCompanyStatus(Long userId, Status status) {
		User existingUser = userRepository.findById(userId).get();
		existingUser.setStatus(status);
		return userMapper.userToCompanyUserResponseDTO(userRepository.save(changeStatus(userId, status)));
	}

	@Override
	public InsuranceUserResponseDTO updateInsuranceStatus(Long userId, Status status) {
		User existingUser = userRepository.findById(userId).get();
		existingUser.setStatus(status);
		return userMapper.userToInsuranceUserResponseDTO(userRepository.save(changeStatus(userId, status)));
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
	public List<ClientResponseDTO> getClients() {
		return userRepository.findByRole(Role.CLEINT).stream()
				.map(user -> userMapper.userToClientResponseDTO(user)).toList();
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
	public List<CompanyUserResponseDTO> getCompanyAdmins(Long companyId){
		return userRepository.findCompanyEmployeesByRole(companyId, Role.COMPANY_ADMIN).stream()
				.map(user -> userMapper.userToCompanyUserResponseDTO(user)).toList();
	}

	@Override
	public List<CompanyUserResponseDTO> getCompanyEmployees(Long companyId) {
		return userRepository.findByCompanyId(companyId).stream()
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
	public AuthenticationResponseDTO getUserByLoginOrEmail(String login, String email, String password) {
		User existingUser = userRepository.findByLoginOrEmail(login, email);
		if (existingUser != null && existingUser.getPassword().equals(password)) {
			return userMapper.userToAuthenticationResponseDTO(existingUser);
		}
		return null;
	}


}
