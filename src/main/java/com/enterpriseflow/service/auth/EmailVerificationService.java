package com.enterpriseflow.service.auth;

public interface EmailVerificationService {

    void createVerificationToken(Long userId);

    void verifyToken(String token);
}
