package com.enterpriseflow.serviceimpl.auth;

import com.enterpriseflow.entity.auth.EmailVerificationToken;
import com.enterpriseflow.entity.auth.User;
import com.enterpriseflow.repository.auth.EmailVerificationTokenRepository;
import com.enterpriseflow.repository.auth.UserRepository;
import com.enterpriseflow.service.auth.EmailVerificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class EmailVerificationServiceImpl implements EmailVerificationService {

    private final EmailVerificationTokenRepository tokenRepository;
    private final UserRepository userRepository;

    @Override
    public void createVerificationToken(Long userId) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        // random UUID token generate kar rahe hain
        String token = UUID.randomUUID().toString();

        EmailVerificationToken verificationToken =
                EmailVerificationToken.builder()
                        .token(token)
                        .expiryDate(LocalDateTime.now().plusMinutes(15)) // 15 min expiry
                        .user(user)
                        .build();

        tokenRepository.save(verificationToken);

        // abhi actual email send nahi kar rahe
        System.out.println("Verification Link: http://localhost:8080/api/auth/verify?token=" + token);
    }

    @Override
    public void verifyToken(String token) {

        EmailVerificationToken verificationToken =
                tokenRepository.findByToken(token)
                        .orElseThrow(() -> new RuntimeException("Invalid token"));

        if (verificationToken.getExpiryDate().isBefore(LocalDateTime.now())) {
            throw new RuntimeException("Token expired");
        }

        User user = verificationToken.getUser();
        user.setActive(true);

        userRepository.save(user);

        tokenRepository.delete(verificationToken);
    }
}
