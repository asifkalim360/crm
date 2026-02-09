package com.enterpriseflow.dto.auth;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
// ye DTO user registration ke liye use hoga.
public class RegisterRequestDto {
	
	@NotBlank(message ="Full name is required")
	// name blank nahi hona chahye.
	private String fullName; 
	
	@NotBlank(message="Email is required")
	@Email(message="Invalid email format")
	// proper emil format validate karega.
	private String email; 
	
	@NotBlank(message="Password is required")
	@Size(min=6, message="Password must be at least 6 charachters")
	// password minimum 6 character rakhna hoga. 
	private String password; 
	
	
}