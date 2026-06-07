package com.phil3lab.diamond.auth.domain.model;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class User {

    private Long id;
    private String email;
    private String password;
    private String nickname;
    private String profileMessage;
    private Provider provider;
    private Role role;
    private LocalDateTime createdAt;

    public enum Provider {
        EMAIL, KAKAO, GOOGLE
    }

    public enum Role {
        USER, ADMIN
    }
}