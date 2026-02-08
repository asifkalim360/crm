package com.enterpriseflow.audit;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@EnableJpaAuditing(auditorAwareRef = "auditorAwareImpl")
//ye annotation JPA auditing ko activate karta hai
//yaha spring ko bol rahe hain ki kaunsi class current auditor provide karegi

public class AuditConfig {
	
		
}

