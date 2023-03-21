package com.tunidesign.utilisateurmicroservice.web;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.zip.Deflater;

import com.tunidesign.utilisateurmicroservice.mapper.UserMapperImpl;
import com.tunidesign.utilisateurmicroservice.model.entity.User;
import com.tunidesign.utilisateurmicroservice.model.enumeration.Role;
import jakarta.annotation.security.RolesAllowed;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.tunidesign.utilisateurmicroservice.DTO.AgencyUserRequestDTO;
import com.tunidesign.utilisateurmicroservice.DTO.AgencyUserResponseDTO;
import com.tunidesign.utilisateurmicroservice.DTO.ClientRequestDTO;
import com.tunidesign.utilisateurmicroservice.DTO.ClientResponseDTO;
import com.tunidesign.utilisateurmicroservice.DTO.CompanyUserRequestDTO;
import com.tunidesign.utilisateurmicroservice.DTO.CompanyUserResponseDTO;
import com.tunidesign.utilisateurmicroservice.DTO.InsuranceUserRequestDTO;
import com.tunidesign.utilisateurmicroservice.DTO.InsuranceUserResponseDTO;
import com.tunidesign.utilisateurmicroservice.DTO.PictureRequestDTO;
import com.tunidesign.utilisateurmicroservice.DTO.UserRequestDTO;
import com.tunidesign.utilisateurmicroservice.DTO.UserResponseDTO;
import com.tunidesign.utilisateurmicroservice.exceptions.CustomException;
import com.tunidesign.utilisateurmicroservice.model.enumeration.Status;
import com.tunidesign.utilisateurmicroservice.service.UserServiceImpl;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {
	@Autowired
	private UserServiceImpl userService;
	static Logger logger = LoggerFactory.getLogger(UserController.class);
	private UserMapperImpl userMapper = new UserMapperImpl();
//	@PostMapping("/authenticate")
//	public ResponseEntity<AuthenticationResponseDTO> authenticate(@RequestBody CredentialsDTO user) {
//		return new ResponseEntity<>(userService.getUserByLoginOrEmail(user.getIdentifier(), user.getPassword()),
//				HttpStatus.OK);
//	}

	/*@PostMapping("/authenticate")
	public ResponseEntity<TokenResponseDTO> signIn(@RequestBody CredentialsDTO credentialsDto) {
		log.info("Trying to login {}", credentialsDto.getIdentifier());
		AuthenticationResponseDTO user = userService.getUserByLoginOrEmail(credentialsDto.getIdentifier(),
				credentialsDto.getPassword());
		if (user == null)
			throw new UserNotFoundException("User not found");
		if (userService.isPasswordsMatched(credentialsDto.getPassword(), user.getPassword())) {
			return new ResponseEntity(
					new TokenResponseDTO(jwtTokenUtil.generateToken(user.getIdentifier(), user.getRole())),
					HttpStatus.OK);
		} else {
			throw new InvalidPasswordException("Invalid password");
		}
	}*/
//	 @PostMapping("/validateToken")
//	    public ResponseEntity<AuthenticationResponseDTO> signIn(@RequestParam String token) {
//	        log.info("Trying to validate token {}", token);
//	        return ResponseEntity.ok(userService.validateToken(token));
//	    }
	@PostMapping("/addSuperAdmin")
	@RolesAllowed({"SUPER_ADMIN"})
	public ResponseEntity<ClientResponseDTO> addSuperAdmin(@Valid @RequestBody ClientRequestDTO clientRequestDTO) {
		try {
			User savedClient = userService.updateRole(userService.addUser(userMapper.clientRequestDTOToUser(clientRequestDTO)).getUserId(), Role.SUPER_ADMIN);
			return new ResponseEntity<>(userMapper.userToClientResponseDTO(savedClient), HttpStatus.CREATED);
		} catch (Exception e) {
			throw new CustomException(e.getMessage());
		}
	}
	@PostMapping("/addClient")
	public ResponseEntity<ClientResponseDTO> addClient(@RequestBody ClientRequestDTO clientRequestDTO) {
		try {
			User savedClient = userService.updateRole(userService.addUser(userMapper.clientRequestDTOToUser(clientRequestDTO)).getUserId(), Role.CLEINT);
			logger.info(String.valueOf(savedClient));
			return new ResponseEntity<>(userMapper.userToClientResponseDTO(savedClient), HttpStatus.CREATED);
		} catch (Exception e) {
			throw new CustomException(e.getMessage());
		}
	}

	@PostMapping("/addDriver")
	@RolesAllowed({"COMPANY_ADMIN"})
	public ResponseEntity<CompanyUserResponseDTO> addDriver(
			@Valid @RequestBody CompanyUserRequestDTO driverRequestDTO) {
		try {
			User savedDriver = userService.updateRole(userService.addUser(userMapper.companyUserRequestDTOToUser(driverRequestDTO)).getUserId(), Role.DRIVER);
			return new ResponseEntity<>(userMapper.userToCompanyUserResponseDTO(savedDriver), HttpStatus.CREATED);
		} catch (Exception e) {
			throw new CustomException(e.getMessage());
		}
	}

	@PostMapping("/addTA")
	@RolesAllowed({"COMPANY_ADMIN"})
	public ResponseEntity<CompanyUserResponseDTO> addTA(@Valid @RequestBody CompanyUserRequestDTO taRequestDTO) {
		try {
			User savedTa = userService.updateRole(userService.addUser(userMapper.companyUserRequestDTOToUser(taRequestDTO)).getUserId(), Role.TA);
			return new ResponseEntity<>(userMapper.userToCompanyUserResponseDTO(savedTa), HttpStatus.CREATED);
		} catch (Exception e) {
			throw new CustomException(e.getMessage());
		}
	}

	@PostMapping("/addCompanyAdmin")
	public ResponseEntity<CompanyUserResponseDTO> addCompanyAdmin(
			@Valid @RequestBody CompanyUserRequestDTO companyAdminRequestDTO) {
		try {
			User savedCompanyAdmin = userService.updateRole(userService.addUser(userMapper.companyUserRequestDTOToUser(companyAdminRequestDTO)).getUserId(), Role.COMPANY_ADMIN);
			return new ResponseEntity<>(userMapper.userToCompanyUserResponseDTO(savedCompanyAdmin), HttpStatus.CREATED);
		} catch (Exception e) {
			throw new CustomException(e.getMessage());
		}
	}

	@PostMapping("/addExpert")
	@RolesAllowed({"INSURANCE_ADMIN"})
	public ResponseEntity<InsuranceUserResponseDTO> addExpert(
			@Valid @RequestBody InsuranceUserRequestDTO expertRequestDTO) {
		try {
			User savedExpert = userService.updateRole(userService.addUser(userMapper.insuranceUserRequestDTOToUser(expertRequestDTO)).getUserId(), Role.EXPERT);
			return new ResponseEntity<>(userMapper.userToInsuranceUserResponseDTO(savedExpert), HttpStatus.CREATED);
		} catch (Exception e) {
			throw new CustomException(e.getMessage());
		}
	}

	@PostMapping("/addAgencyAdmin")
	@RolesAllowed({"INSURANCE_ADMIN"})
	public ResponseEntity<AgencyUserResponseDTO> addAgencyAdmin(
			@Valid @RequestBody AgencyUserRequestDTO agencyAdminRequestDTO) {
		try {
			User savedAgencyAdmin = userService.updateRole(userService.addUser(userMapper.agencyUserRequestDTOToUser(agencyAdminRequestDTO)).getUserId(), Role.AGENCY_ADMIN);
			return new ResponseEntity<>(userMapper.userToAgencyUserResponseDTO(savedAgencyAdmin), HttpStatus.CREATED);
		} catch (Exception e) {
			throw new CustomException(e.getMessage());
		}
	}

	@PostMapping("/addInsuranceAdmin")
	public ResponseEntity<InsuranceUserResponseDTO> addInsuranceAdmin(
			@Valid @RequestBody InsuranceUserRequestDTO insuranceAdminRequestDTO) {
		try {
			User savedInsuranceAdmin = userService.updateRole(userService.addUser(userMapper.insuranceUserRequestDTOToUser(insuranceAdminRequestDTO)).getUserId(), Role.INSURANCE_ADMIN);
			return new ResponseEntity<>(userMapper.userToInsuranceUserResponseDTO(savedInsuranceAdmin), HttpStatus.CREATED);
		} catch (Exception e) {
			throw new CustomException(e.getMessage());
		}
	}

	@PostMapping("/uploadImage/{userId}")
	public ResponseEntity<UserResponseDTO> uplaodImage(@PathVariable Long userId,
			@RequestParam("imageFile") MultipartFile file) throws IOException {

		logger.info("Original Image Byte Size - " + file.getBytes().length);
		logger.info(String.valueOf(userId));
		// add image
		PictureRequestDTO pictureRequestDTO = PictureRequestDTO.builder().userId(userId).pictureName(file.getOriginalFilename())
				.pictureType(file.getContentType()).pictureByte(compressBytes(file.getBytes())).build();
		return new ResponseEntity<>(userMapper.userToUserResponseDTO(userService.uploadPicture(pictureRequestDTO)), HttpStatus.ACCEPTED);
	}

	/* *********************** update status ********************** */
	@PutMapping("/updateCompanyStatus/{userId}/{status}")
	@RolesAllowed({"COMPANY_ADMIN", "TA", "DRIVER"})
	public ResponseEntity<CompanyUserResponseDTO> updateCompanyStatus(@PathVariable Long userId,
			@PathVariable Status status) {
		if (userService.isExist(userId)) {
			return ResponseEntity.accepted().body(userMapper.userToCompanyUserResponseDTO(userService.changeStatus(userId, status)));
		} else
			throw new EntityNotFoundException("User doesn't exist");
	}

	@PutMapping("/updateAgencyStatus/{userId}/{status}")
	@RolesAllowed({"AGENCY_ADMIN"})
	public ResponseEntity<AgencyUserResponseDTO> updateAgencyStatus(@PathVariable Long userId,
			@PathVariable Status status) {
		if (userService.isExist(userId)) {
			return ResponseEntity.accepted().body(userMapper.userToAgencyUserResponseDTO(userService.changeStatus(userId, status)));
		} else
			throw new EntityNotFoundException("User doesn't exist");
	}

	@PutMapping("/updateInsuranceStatus/{userId}/{status}")
	@RolesAllowed({"INSURANCE_ADMIN", "EXPERT"})
	public ResponseEntity<InsuranceUserResponseDTO> updateInsuranceStatus(@PathVariable Long userId,
			@PathVariable Status status) {
		if (userService.isExist(userId)) {
			return ResponseEntity.accepted().body(userMapper.userToInsuranceUserResponseDTO(userService.changeStatus(userId, status)));
		} else
			throw new EntityNotFoundException("User doesn't exist");
	}

	/* ******************* update user ******************* */
	@PutMapping("update")
	public ResponseEntity<UserResponseDTO> updateUser(@Valid @RequestBody UserRequestDTO userRequestDTO) {

		try {
			if (userService.isExist(userRequestDTO.getUserId())) {
				User savedUser = userService.updateUser(userMapper.userRequestDTOToUser(userRequestDTO));
				return ResponseEntity.accepted().body(userMapper.userToUserResponseDTO(savedUser));
			} else
				throw new EntityNotFoundException("User doesn't exist");

		} catch (Exception e) {
			throw new CustomException(e.getMessage());
		}
	}

//	  @GetMapping("/users")
//	    public ResponseEntity<List<User>> getAllUsers(@AuthenticationPrincipal User user) {
//	        if (user.getRole() == Role.ADMIN) {
//	            List<User> users = userService.findAll();
//	            return ResponseEntity.ok(users);
//	        } else {
//	            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
//	        }
//	    }
	/* *********************** get All ********************** */
	@GetMapping("/getAll/clients")
	public ResponseEntity<List<ClientResponseDTO>> getClients() {
		return ResponseEntity.ok().body(userService.getClients());
	}

	@GetMapping("/getAll/company/drivers/{companyId}")
	@RolesAllowed({"COMPANY_ADMIN", "TA"})
	public ResponseEntity<List<CompanyUserResponseDTO>> getDrivers(@PathVariable Long companyId) {
		return ResponseEntity.ok().body(userService.getDrivers(companyId));
	}

	@GetMapping("/getAll/company/TA/{companyId}")
	@RolesAllowed({"COMPANY_ADMIN"})
	public ResponseEntity<List<CompanyUserResponseDTO>> getTAs(@PathVariable Long companyId) {
		return ResponseEntity.ok().body(userService.getTAs(companyId));
	}

	@GetMapping("/getAll/company/admin/{companyId}")
	@RolesAllowed({"COMPANY_ADMIN"})
	public ResponseEntity<List<CompanyUserResponseDTO>> getCompanyAdmins(@PathVariable Long companyId) {
		return ResponseEntity.ok().body(userService.getCompanyAdmins(companyId));
	}

	@GetMapping("/getAll/company/employees/{companyId}")
	@RolesAllowed({"COMPANY_ADMIN"})
	public ResponseEntity<List<CompanyUserResponseDTO>> getCompanyEmployees(@PathVariable Long companyId) {
		return ResponseEntity.ok().body(userService.getCompanyEmployees(companyId));
	}
	@GetMapping("/agency/admin/{agencyId}")
	@RolesAllowed({"AGENCY_ADMIN", "INSURANCE_ADMIN"})
	public ResponseEntity<List<AgencyUserResponseDTO>> getAgencyAdmins(@PathVariable Long agencyId) {
		return ResponseEntity.ok().body(userService.getAgencyAdmins(agencyId));
	}

	@GetMapping("/getAll/agency/employees/{agencyId}")
	@RolesAllowed({"INSURANCE_ADMIN"})
	public ResponseEntity<List<AgencyUserResponseDTO>> getAgencyEmployees(@PathVariable Long agencyId) {
		return ResponseEntity.ok().body(userService.getAgencyEmployees(agencyId));
	}

	@GetMapping("/getAll/insurance/admin/{insuranceId}")
	@RolesAllowed({"INSURANCE_ADMIN"})
	public ResponseEntity<List<InsuranceUserResponseDTO>> getInsurancAdmins(@PathVariable Long insuranceId) {
		return ResponseEntity.ok().body(userService.getInsuranceAdmins(insuranceId));
	}

	@GetMapping("/getAll/insurance/expert/{insuranceId}")
	@RolesAllowed({"INSURANCE_ADMIN"})
	public ResponseEntity<List<InsuranceUserResponseDTO>> getInsuranceExperts(@PathVariable Long insuranceId) {
		return ResponseEntity.ok().body(userService.getExperts(insuranceId));
	}

	@GetMapping("/getAll/insurance/employees/{insuranceId}")
	@RolesAllowed({"INSURANCE_ADMIN"})
	public ResponseEntity<List<InsuranceUserResponseDTO>> getInsuranceEmployees(@PathVariable Long insuranceId) {
		return ResponseEntity.ok().body(userService.getInsuranceEmployees(insuranceId));
	}

//	@GetMapping("")
//	public ResponseEntity<List<UserResponseDTO>> getAllUsers() {
//		return ResponseEntity.ok().body(userService.getUsers());
//	}
	/* *********************** get By Id ********************** */
	@GetMapping("/{userId}")
	@RolesAllowed({"CLEINT", "SUPER_ADMIN", "COMPANY_ADMIN", "TA", "DRIVER", "AGENCY_ADMIN", "INSURANCE_ADMIN",
			"EXPERT", "PRESTATAIRE"})
	public ResponseEntity<UserResponseDTO> getUser(@PathVariable Long userId) {
		try {
			return ResponseEntity.ok().body(userMapper.userToUserResponseDTO(userService.getUser(userId)));
		} catch (Exception ex) {
			throw new EntityNotFoundException("User doesn't exist");
		}
	}

	/* ******************* delete user ****************** */
	@DeleteMapping("/{userId}")
	public ResponseEntity<?> deleteUser(@PathVariable Long userId) {
		try {
			userService.deleteUser(userId);
			return ResponseEntity.noContent().build();
		} catch (Exception ex) {
			throw new EntityNotFoundException("User doesn't exist");
		}
	}

	// compress the image bytes before storing it in the database
	public static byte[] compressBytes(byte[] data) {
		Deflater deflater = new Deflater();
		deflater.setInput(data);
		deflater.finish();

		ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
		byte[] buffer = new byte[1024];
		while (!deflater.finished()) {
			int count = deflater.deflate(buffer);
			outputStream.write(buffer, 0, count);
		}
		try {
			outputStream.close();
		} catch (IOException e) {
		}
		logger.info("Compressed Image Byte Size - " + outputStream.toByteArray().length);

		return outputStream.toByteArray();
	}

}
