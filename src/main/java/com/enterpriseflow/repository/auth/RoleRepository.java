package com.enterpriseflow.repository.auth;

import com.enterpriseflow.entity.auth.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {

//    // role name se find karne ke liye
//    Optional<Role> findByName(String name);
    
    
}
