package com.app.gestionreservationssalles.auth.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder()
public class AuthResponseDTO {
    private String accessToken;
    private String refreshToken;
}

