package com.enterpriseflow.controller.auth;

import com.enterpriseflow.constant.SuccessMessage;
import com.enterpriseflow.dto.auth.RegisterRequestDto;
import com.enterpriseflow.response.ApiResponse;
import com.enterpriseflow.service.auth.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
// authentication related endpoints yaha rahenge
public class AuthController {

    private final AuthService authService;
	
    @PostMapping("/register")
    public ResponseEntity<ApiResponse<?>> registerUser( @Valid @RequestBody RegisterRequestDto registrationRequest)
    {
    	authService.registerUser(registrationRequest);
    	return ResponseEntity.status(HttpStatus.CREATED)
    			.body(ApiResponse.success(SuccessMessage.USER_REGISTERED_SUCCESS, null));
    }
    
    
    
}
