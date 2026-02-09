package com.enterpriseflow.entity.auth;

import com.enterpriseflow.entity.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter 
@Setter
@Entity 
@Table
public class Role extends BaseEntity {
	
	@Column(unique=true, nullable=false)
	//role ka name unique hoga.(ADMIN, MANAGER, USER)
	private String name; 
	
	@Column 
	// role ka description.
	private String description;
	
}