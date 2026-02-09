package com.enterpriseflow.service.auth;

import com.enterpriseflow.dto.auth.RegisterRequestDto;
import com.enterpriseflow.response.ApiResponse;

public interface AuthService {
	
	// user registration method.
	ApiResponse<?> register(RegisterRequestDto request);
	
}