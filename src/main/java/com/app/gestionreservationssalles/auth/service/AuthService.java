package com.app.gestionreservationssalles.auth.service;

import com.app.gestionreservationssalles.auth.dto.request.LoginRequestDTO;
import com.app.gestionreservationssalles.auth.dto.request.RefreshTokenRequestDTO;
import com.app.gestionreservationssalles.auth.dto.response.AuthResponseDTO;
import com.app.gestionreservationssalles.auth.dto.response.RefreshTokenResponseDTO;

public interface AuthService {
    AuthResponseDTO login(LoginRequestDTO request);
    AuthResponseDTO refreshToken(RefreshTokenRequestDTO request );

}
