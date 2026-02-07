package com.enterpriseflow.audit;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@EnableJpaAuditing
// ye annotation JPA auditing ko activate karta hai
public class AuditConfig {
}
