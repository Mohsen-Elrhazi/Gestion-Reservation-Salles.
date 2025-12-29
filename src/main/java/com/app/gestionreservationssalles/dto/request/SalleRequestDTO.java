package com.app.gestionreservationssalles.dto.request;

import com.app.gestionreservationssalles.enums.TypeSalle;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

public class SalleRequestDTO {
    private String numero;

    private String nom;

    private int capacite;

    private TypeSalle type;
}
