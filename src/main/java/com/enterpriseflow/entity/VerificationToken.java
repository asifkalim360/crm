package com.enterpriseflow.entity;

import jakarta.persistence.*;


import java.time.LocalDateTime;

import com.enterpriseflow.entity.auth.User;

@Entity
public class VerificationToken {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String token;

    private LocalDateTime expiryDate;

    private boolean used;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    // getters setters
}
