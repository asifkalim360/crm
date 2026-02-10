package com.enterpriseflow.controller.auth;

import com.enterpriseflow.dto.auth.RegisterRequestDto;
import com.enterpriseflow.response.ApiResponse;
import com.enterpriseflow.service.auth.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
// authentication related endpoints yaha rahenge
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<ApiResponse<?>> register(
            @Valid @RequestBody RegisterRequestDto request) {

        return ResponseEntity.status(201)
                .body(authService.register(request));
    	
    }
}
