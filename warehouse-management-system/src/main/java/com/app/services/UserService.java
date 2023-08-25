package com.app.services;

import com.app.dto.AddUserDto;
import com.app.dto.SigninRequest;
import com.app.dto.SigninResponse;
import com.app.entities.User;

public interface UserService {
	SigninResponse authenticate(SigninRequest request);
	public User createUser(AddUserDto user);
}
