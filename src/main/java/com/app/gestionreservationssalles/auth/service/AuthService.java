package com.app.gestionreservationssalles.auth.service;

import com.app.gestionreservationssalles.auth.dto.*;

public interface AuthService {
    AuthResponseDTO login(LoginRequestDTO request);
}
