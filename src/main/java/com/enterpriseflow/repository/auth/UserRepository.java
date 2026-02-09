package com.enterpriseflow.repository.auth;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.enterpriseflow.entity.auth.User;

public interface UserRepository extends JpaRepository<User, Long>
{
//	// emial se user fetch karenge login ke time
//	public Optional<User> findByEmail(String email); 
//	
//	//email exist check karne ke liye.
//	boolean existsByEmail(String email);
}