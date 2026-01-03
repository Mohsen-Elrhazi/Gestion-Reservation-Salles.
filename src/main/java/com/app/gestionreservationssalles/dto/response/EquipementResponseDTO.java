package com.app.gestionreservationssalles.dto.response;

import com.app.gestionreservationssalles.entity.Reservation;
import com.app.gestionreservationssalles.enums.TypeEquipement;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EquipementResponseDTO {
    private long id;

    private String nom;

    private double poids;

    private TypeEquipement type;

}
