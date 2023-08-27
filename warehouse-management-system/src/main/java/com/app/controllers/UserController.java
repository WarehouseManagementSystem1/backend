package com.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.AddUserDto;
import com.app.dto.ApiResponse;
import com.app.dto.SigninRequest;
import com.app.entities.User;
import com.app.services.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;

	@PostMapping("/login")
	public ResponseEntity<?> userLogin(@RequestBody @Valid SigninRequest request){
		try {
			return new ResponseEntity<>(userService.authenticate(request), HttpStatus.OK);
		}catch (RuntimeException e) {
			System.out.println(e);
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(e.getMessage()));
		}
		
		
	}
	@PostMapping("/adduser")
	 public ResponseEntity<String> createUser(@RequestBody AddUserDto newUser) {
//			System.out.println("in side controller");
//			System.out.println(newUser.getFirstname());
//			System.out.println(newUser.getLastname());
//			System.out.println(newUser);
	        User createdUser = userService.createUser(newUser);
	        if (createdUser != null) {
	            return new ResponseEntity<>("User created successfully", HttpStatus.OK);
	        }
	        return new ResponseEntity<>("Failed to create user", HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	
}
