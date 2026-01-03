package com.app.gestionreservationssalles.dto.request;

import com.app.gestionreservationssalles.enums.TypeEquipement;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EquipementPatchDTO {

    private String nom;

    private Double poids;

    private TypeEquipement type;

}
