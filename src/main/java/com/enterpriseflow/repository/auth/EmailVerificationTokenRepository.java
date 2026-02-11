package com.enterpriseflow.repository.auth;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.enterpriseflow.entity.auth.EmailVerificationToken;

public interface EmailVerificationTokenRepository
        extends JpaRepository<EmailVerificationToken, Long> {

    Optional<EmailVerificationToken> findByToken(String token);
}
