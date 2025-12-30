package com.app.gestionreservationssalles.dto.request;

import com.app.gestionreservationssalles.enums.TypeSalle;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SalleRequestDTO {
    @NotBlank(message = "Le numéro de salle ne peut pas être vide")
    private String numero;

    @NotBlank(message = "Le nom de la salle ne peut pas être vide")
    private String nom;

    @Min(value = 1, message = "La capacité doit être au moins de 1")
    private int capacite;

    @NotNull(message = "Le type de salle doit être défini")
    private TypeSalle type;
}
