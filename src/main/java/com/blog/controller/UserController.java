package com.blog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.blog.payLoads.APIResponce;
import com.blog.payLoads.UserDto;
import com.blog.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

// save user
	@PostMapping("/save")
	public ResponseEntity<UserDto> test(@RequestBody UserDto userDto) {
		System.out.println(userDto);
		System.out.println("==============");
		UserDto user = userService.createUser(userDto);
		ResponseEntity<UserDto> responseEntity = new ResponseEntity<UserDto>(user, HttpStatus.CREATED);

		return responseEntity;
	}

	// get All User
	@GetMapping("/get")
	public ResponseEntity<List<UserDto>> getAllUser() {

		return ResponseEntity.ok(this.userService.getAllUser());
	}

	// get Single User
	@GetMapping("/getsingle/{userId}")
	public ResponseEntity<UserDto> getSingleUser(@PathVariable("userId") int userId) {
		return ResponseEntity.ok(this.userService.getSingleUser(userId));

	}

	// Update User
	@PutMapping("/update")
	public ResponseEntity<UserDto> updateUser(@RequestBody UserDto userDto) {
		return ResponseEntity.ok(this.userService.updateUser(userDto));
	}

	// Delete User
	@DeleteMapping("/delete/{userId}")
	public ResponseEntity<APIResponce> deleteUser(@PathVariable("userId") int userId) {
		this.userService.deleteUser(userId);
		APIResponce a = new APIResponce("User Delete Successfully", true);
		return new ResponseEntity<APIResponce>(a, HttpStatus.OK);
	}
}
