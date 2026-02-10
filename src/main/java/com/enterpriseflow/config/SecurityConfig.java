package com.enterpriseflow.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration 
// yahan password encoder bean define kar rahe hain.
public class SecurityConfig {
	
	@Bean
	public PasswordEncoder passwordEncoder()
	{
		// Bcrypt industry standard hasing algorithm hai.
		return new BCryptPasswordEncoder();
	}
	
}


