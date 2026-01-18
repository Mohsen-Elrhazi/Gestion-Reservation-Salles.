package com.app.gestionreservationssalles.auth.service.impl;

import com.app.gestionreservationssalles.auth.dto.request.LoginRequestDTO;
import com.app.gestionreservationssalles.auth.dto.request.RefreshTokenRequestDTO;
import com.app.gestionreservationssalles.auth.dto.response.AuthResponseDTO;
import com.app.gestionreservationssalles.auth.service.AuthService;
import com.app.gestionreservationssalles.auth.service.RefreshTokenService;
import com.app.gestionreservationssalles.entity.RefreshToken;
import com.app.gestionreservationssalles.entity.User;
import com.app.gestionreservationssalles.repository.UserRepository;
import com.app.gestionreservationssalles.security.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.app.gestionreservationssalles.exception.ResourceNotFoundException;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;
    private final RefreshTokenService refreshTokenService;

    @Override
    public AuthResponseDTO login(LoginRequestDTO request) {
        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new ResourceNotFoundException("email ou mot de passe incorrect"));

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getMotDePasse())
        );


        String accessToken  = jwtService.generateToken(user);
//        String refreshToken = jwtService.generateRefreshToken(user);
        String refreshToken = refreshTokenService.createRefreshToken(user);
        return new AuthResponseDTO(accessToken, refreshToken );
    }

    @Override
    public AuthResponseDTO refreshToken(RefreshTokenRequestDTO request) {
        RefreshToken oldToken= refreshTokenService.findByToken(request.getRefreshToken());

        refreshTokenService.verifyExpiration(oldToken);

        User user = oldToken.getUser();

        // Invalider l'ancien refresh token
        refreshTokenService.deleteByUser(user);

        String newAccessToken = jwtService.generateToken(user);
        String newRefreshToken= refreshTokenService.createRefreshToken(user);
        return new AuthResponseDTO(newAccessToken, newRefreshToken);

    }

    @Override
    public void logout(RefreshTokenRequestDTO request) {
        RefreshToken token = refreshTokenService.findByToken(request.getRefreshToken());
        User user = token.getUser();
        refreshTokenService.deleteByUser(user);
    }
}
