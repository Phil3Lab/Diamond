package com.phil3lab.diamond.auth.domain.port.in;

import com.phil3lab.diamond.auth.adapter.in.web.dto.LoginRequest;
import com.phil3lab.diamond.auth.adapter.in.web.dto.SignUpRequest;
import com.phil3lab.diamond.auth.adapter.in.web.dto.TokenResponse;

public interface AuthUseCase {

    TokenResponse signUp(SignUpRequest request);

    TokenResponse login(LoginRequest request);

    void logout(String accessToken);

    TokenResponse reissue(String refreshToken);
}