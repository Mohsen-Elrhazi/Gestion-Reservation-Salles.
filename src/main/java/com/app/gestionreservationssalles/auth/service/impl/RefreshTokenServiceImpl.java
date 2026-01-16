package com.app.gestionreservationssalles.auth.service.impl;

import com.app.gestionreservationssalles.auth.service.RefreshTokenService;
import com.app.gestionreservationssalles.entity.RefreshToken;
import com.app.gestionreservationssalles.entity.User;
import com.app.gestionreservationssalles.exception.ResourceNotFoundException;
import com.app.gestionreservationssalles.repository.RefreshTokenRepository;
import com.app.gestionreservationssalles.security.JwtService;
import jakarta.persistence.RefreshOption;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Optional;
import java.util.UUID;

@Service

public class RefreshTokenServiceImpl implements RefreshTokenService {
    @Value("${jwt.refreshExpirationMs}")
    private long refreshTokenDurationMs;

    private final RefreshTokenRepository refreshTokenRepository;
    private final JwtService jwtService;

    public RefreshTokenServiceImpl(RefreshTokenRepository refreshTokenRepository, JwtService jwtService) {
        this.refreshTokenRepository = refreshTokenRepository;
        this.jwtService = jwtService;
    }

    @Override
    public String createRefreshToken(User user) {
        Optional<RefreshToken> existingToken = refreshTokenRepository.findByUser(user);
        if (existingToken.isPresent()) {
            refreshTokenRepository.delete(existingToken.get());
        }

        RefreshToken token = new RefreshToken();
        token.setUser(user);
        token.setExpiryDate(Instant.now().plusMillis(refreshTokenDurationMs));
        token.setToken(UUID.randomUUID().toString());
//        token.setToken(jwtService.generateRefreshToken(user));
        refreshTokenRepository.save(token);
        return token.getToken();
    }

    public RefreshToken verifyExpiration(RefreshToken token) {
        if (token.getExpiryDate().isBefore(Instant.now())) {
            refreshTokenRepository.delete(token);
            throw new ResourceNotFoundException("Refresh token expired");
        }
        return token;
    }

    @Override
    public boolean deleteByUser(User user) {
        Optional<RefreshToken> token = refreshTokenRepository.findByUser(user);
        if (token.isPresent()) {
            refreshTokenRepository.delete(token.get());
            return true;
        }
        return false;
    }

    @Override
    public RefreshToken findByToken(String token) {
       return refreshTokenRepository.findByToken(token)
                .orElseThrow(() -> new ResourceNotFoundException("Refresh token not found"));
    }


}
