package com.enterpriseflow.serviceimpl.auth;

import java.time.LocalDateTime;
import java.util.Collections;

import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.enterpriseflow.constant.ErrorMessage;
import com.enterpriseflow.constant.SuccessMessage;
import com.enterpriseflow.dto.auth.RegisterRequestDto;
import com.enterpriseflow.entity.auth.Role;
import com.enterpriseflow.entity.auth.User;
import com.enterpriseflow.exception.BusinessException;
import com.enterpriseflow.repository.auth.RoleRepository;
import com.enterpriseflow.repository.auth.UserRepository;
import com.enterpriseflow.response.ApiResponse;
import com.enterpriseflow.service.auth.AuthService;

import lombok.RequiredArgsConstructor;


@Service 
@RequiredArgsConstructor 
// constructor injection use kar rahe hain.
public class AuthServiceImpl implements AuthService {

	private final UserRepository userRepository; 
	private final RoleRepository roleRepository; 
	private final PasswordEncoder passwordEncoder;
	
//  //  constructor banane ki jrurt nahi padti uske liye humlog ye annotation(@RequiredArgsConstructor) ka use kar sakte hain. 
//	public AuthServiceImpl(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder)
//	{
//		this.userRepository = userRepository;
//		this.roleRepository = roleRepository; 
//		this.passwordEncoder = passwordEncoder;
//	}
		
	@Override
	public ApiResponse<?> register(RegisterRequestDto request) {
		
		// check kar rahe hain email already exist to nahi.
		if(userRepository.existsByEmail(request.getEmail()))
		{
			throw new BusinessException(ErrorMessage.USER_ALREADY_EXISTS);
		}
		
		// default USER role fetch karenge.
		Role userRole = roleRepository.findByName("USER") 
				.orElseThrow(()-> new BusinessException("Default role not found"));
		
		User user = new User();
		user.setFullName(request.getFullName());
		user.setEmail(request.getEmail());
		
		// password ko yahan pe hash kar rahe hain.
		user.setPassword(request.getPassword());
		user.setRoles(Collections.singleton(userRole)); 
		
		userRepository.save(user); 
		
		return ApiResponse.builder() 
				.success(true)
				.statusCode(HttpStatus.CREATED.value())
				.message(SuccessMessage.USER_REGISTERED)
				.data(null) 
				.timestamp(LocalDateTime.now())
				.build();
	}
	
}