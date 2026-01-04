package com.app.gestionreservationssalles.dto.response;

import com.app.gestionreservationssalles.entity.Equipement;
import com.app.gestionreservationssalles.enums.StatutReservation;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReservationResponseDTO {
    private Long id;
    private LocalDate date;
    private Integer duree;
    private String description;
    private StatutReservation statut;

    private String salleNom;
    private String userNom;

    private List<EquipementResponseDTO> equipements;
}
