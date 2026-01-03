package com.app.gestionreservationssalles.service;

import com.app.gestionreservationssalles.dto.request.EquipementPatchDTO;
import com.app.gestionreservationssalles.dto.request.EquipementRequestDTO;
import com.app.gestionreservationssalles.dto.response.EquipementResponseDTO;

import java.util.List;

public interface EquipementService {
    EquipementResponseDTO createEquipement(EquipementRequestDTO equipementRequestDTO);
    EquipementResponseDTO getEquipementById(Long id);
    List<EquipementResponseDTO> getAllEquipements();
    EquipementResponseDTO patchEquipement(Long id, EquipementPatchDTO equipementPatchDTO);
    void deleteEquipement(Long id);
}
