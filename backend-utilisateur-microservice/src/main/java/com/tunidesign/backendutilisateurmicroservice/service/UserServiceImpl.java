package com.tunidesign.backendutilisateurmicroservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tunidesign.backendutilisateurmicroservice.DTO.PictureRequestDTO;
import com.tunidesign.backendutilisateurmicroservice.DTO.UserRequestDTO;
import com.tunidesign.backendutilisateurmicroservice.DTO.UserResponseDTO;
import com.tunidesign.backendutilisateurmicroservice.mapper.UserMapperImpl;
import com.tunidesign.backendutilisateurmicroservice.model.entity.User;
import com.tunidesign.backendutilisateurmicroservice.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	private UserMapperImpl userMapper;
	@Override
	public UserResponseDTO addUser(UserRequestDTO userRequestDTO) {
		return userMapper.userToUserResponseDTO(userRepository.save(userMapper.userRequestDTOToUser(userRequestDTO)));
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
		//User existingUser = userRepository.findById(userRequestDTO.getUserId()).get();
		User user = userMapper.userRequestDTOToUser(userRequestDTO);
		User savedUser= userRepository.save(user);
		return userMapper.userToUserResponseDTO(savedUser);
	}

	@Override
	public List<UserResponseDTO> getUsers() {
		return userRepository.findAll()
				.stream()
				.map(user -> userMapper.userToUserResponseDTO(user))
				.toList();
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
	public Boolean isExist(Long id) {
		return userRepository.findById(id).isPresent();
	}


}
