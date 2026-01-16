package com.app.gestionreservationssalles.auth.dto;

import lombok.Data;

@Data
public class LoginRequestDTO {
    private String email;
    private String motDePasse;
}
