package com.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.RegisterRequest;
import com.app.dto.RegisterResponse;
import com.app.services.OwnerService;

@RestController
@RequestMapping("/owner")
public class OwnerController {

	@Autowired
	OwnerService ownerService;
	
	@PostMapping("/register")
	public ResponseEntity<?> ownerRegister(@RequestBody RegisterRequest newOwner){
		
		try {
			Long ownerId = ownerService.addOwner(newOwner);
			RegisterResponse response = new RegisterResponse("Owner Register Successfully Added !!",ownerId);
			return ResponseEntity.ok(response);
		}catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}
}
