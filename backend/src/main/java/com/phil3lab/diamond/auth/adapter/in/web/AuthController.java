package com.phil3lab.diamond.auth.adapter.in.web;

import com.phil3lab.diamond.auth.adapter.in.web.dto.LoginRequest;
import com.phil3lab.diamond.auth.adapter.in.web.dto.SignUpRequest;
import com.phil3lab.diamond.auth.adapter.in.web.dto.TokenResponse;
import com.phil3lab.diamond.auth.domain.port.in.AuthUseCase;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthUseCase authUseCase;

    @PostMapping("/signup")
    public ResponseEntity<TokenResponse> signUp(@Valid @RequestBody SignUpRequest request) {
        return ResponseEntity.ok(authUseCase.signUp(request));
    }

    @PostMapping("/login")
    public ResponseEntity<TokenResponse> login(@Valid @RequestBody LoginRequest request) {
        return ResponseEntity.ok(authUseCase.login(request));
    }

    @PostMapping("/logout")
    public ResponseEntity<Void> logout(@RequestHeader("Authorization") String token) {
        authUseCase.logout(token.replace("Bearer ", ""));
        return ResponseEntity.ok().build();
    }

    @PostMapping("/reissue")
    public ResponseEntity<TokenResponse> reissue(@RequestHeader("Authorization") String token) {
        return ResponseEntity.ok(authUseCase.reissue(token.replace("Bearer ", "")));
    }
}