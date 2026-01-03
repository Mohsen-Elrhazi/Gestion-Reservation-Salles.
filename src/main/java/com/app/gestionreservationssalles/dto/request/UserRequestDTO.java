package com.app.gestionreservationssalles.dto.request;

import com.app.gestionreservationssalles.enums.Role;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserRequestDTO {

    private String nom;

    private String email;

    private String motDePasse;

    private Role role;
}
