package com.app.services;

import com.app.dto.SigninRequest;
import com.app.dto.SigninResponse;

public interface UserService {
	SigninResponse authenticate(SigninRequest request);
}
