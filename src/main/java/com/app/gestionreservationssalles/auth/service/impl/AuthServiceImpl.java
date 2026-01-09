package com.app.gestionreservationssalles.auth.service.impl;

import com.app.gestionreservationssalles.auth.dto.*;
import com.app.gestionreservationssalles.auth.service.AuthService;
import com.app.gestionreservationssalles.entity.User;
import com.app.gestionreservationssalles.enums.Role;
import com.app.gestionreservationssalles.repository.UserRepository;
import com.app.gestionreservationssalles.security.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;

    @Override
    public AuthResponseDTO login(LoginRequestDTO request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getMotDePasse())
        );

        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("Utilisateur non trouvé"));

        String token = jwtService.generateToken(user);
        return new AuthResponseDTO(token);
    }
}
