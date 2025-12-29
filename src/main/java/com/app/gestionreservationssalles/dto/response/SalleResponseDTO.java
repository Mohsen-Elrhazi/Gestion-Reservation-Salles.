package com.app.gestionreservationssalles.dto.response;


import com.app.gestionreservationssalles.enums.TypeSalle;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

public class SalleResponseDTO {

    private long id;

    private String numero;

    private String nom;

    private int capacite;

    private TypeSalle type;
}
