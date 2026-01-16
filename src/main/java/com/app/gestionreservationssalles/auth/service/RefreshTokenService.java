package com.app.gestionreservationssalles.auth.service;

import com.app.gestionreservationssalles.entity.RefreshToken;
import com.app.gestionreservationssalles.entity.User;

import java.util.Optional;

public interface RefreshTokenService {
    String createRefreshToken(User user);
    RefreshToken findByToken(String token);
    RefreshToken  verifyExpiration(RefreshToken token);
    boolean deleteByUser(User user);
}
