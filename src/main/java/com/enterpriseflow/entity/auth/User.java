package com.enterpriseflow.entity.auth;

import java.util.HashSet;
import java.util.Set;

import com.enterpriseflow.entity.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;


@Getter 
@Setter 
@Entity 
@Table(name = "users")
// yahan user table define ho raha hai.
public class User extends BaseEntity {
	
	@Column(nullable = false)
	private String fullName; 
	
	@Column(unique = true, nullable=false) 
	// email login ke liye use hoga
	private String email; 
	
	@Column(nullable = false)
	// encrypted password store hoga
	private String password; 
	
	@Column(nullable = false)
	// email verify hone tak false rahega.
	private boolean isActive = false;	// register pe false rahega.
	
	@Column(nullable = false)
	// agar account lock ho jaye to false ho jayega.  
	private boolean isAccountNonLocked = true; 
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
			name = "user_roles", 
			joinColumns = @JoinColumn(name = "user_id"),
			inverseJoinColumns = @JoinColumn(name = "role_id")
		)
	// ek user ke multiple roles ho skte hain.
	private Set<Role> roles = new HashSet<>();
	
}