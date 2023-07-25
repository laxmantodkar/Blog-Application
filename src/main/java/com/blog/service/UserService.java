package com.blog.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.entites.User;
import com.blog.payLoads.UserDto;
import com.blog.repository.UserRepo;

@Service
public class UserService {

	@Autowired
	private UserRepo userRepo;

	@Autowired
	private ModelMapper modelMapper;

	// save the user
	public UserDto createUser(UserDto userDto) {
		User user = userDtoToEntity(userDto);
		User savedUser = this.userRepo.save(user);
		return userEntityTOUserDto(savedUser);

	}

	// Update User
	public UserDto updateUser(UserDto userDto) {
		User user = userRepo.findById(userDto.getId());
		user.setName(userDto.getName());
		user.setEmail(userDto.getEmail());
		user.setPassword(userDto.getPassword());
		user.setAbout(userDto.getAbout());
		User saveduser = userRepo.save(user);
		return this.userEntityTOUserDto(saveduser);
	}

	// delete User
	public void deleteUser(int userId) {
		this.userRepo.deleteById(userId);
	}

	// get All User
	public List<UserDto> getAllUser() {
		List<User> user = this.userRepo.findAll();
		List<UserDto> userDto = user.stream().map(u -> this.userEntityTOUserDto(u)).collect(Collectors.toList());
		return userDto;

	}

	// Get Single User

	public UserDto getSingleUser(int userId) {

		User user = this.userRepo.findById(userId);
		return this.userEntityTOUserDto(user);

	}

	private User userDtoToEntity(UserDto userDto) {
		User user = this.modelMapper.map(userDto, User.class);
//		User user = new User();
//		user.setName(userDto.getName());
//		user.setEmail(userDto.getEmail());
//		user.setAbout(userDto.getAbout());
//		user.setPassword(userDto.getPassword());
		return user;

	}

	private UserDto userEntityTOUserDto(User user) {
		UserDto userdto = this.modelMapper.map(user, UserDto.class);
//		UserDto userdto = new UserDto();
//		userdto.setId(user.getId());
//		userdto.setName(user.getName());
//		userdto.setEmail(user.getEmail());
//		userdto.setAbout(user.getAbout());
//		userdto.setPassword(user.getPassword());
		return userdto;
	}
}
