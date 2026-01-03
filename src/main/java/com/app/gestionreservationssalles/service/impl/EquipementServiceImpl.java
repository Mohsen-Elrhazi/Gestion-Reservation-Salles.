package com.app.gestionreservationssalles.service.impl;

import com.app.gestionreservationssalles.dto.request.EquipementPatchDTO;
import com.app.gestionreservationssalles.dto.request.EquipementRequestDTO;
import com.app.gestionreservationssalles.dto.response.EquipementResponseDTO;
import com.app.gestionreservationssalles.entity.Equipement;
import com.app.gestionreservationssalles.exception.ResourceNotFoundException;
import com.app.gestionreservationssalles.mapper.EquipementMapper;
import com.app.gestionreservationssalles.repository.EquipementRepository;
import com.app.gestionreservationssalles.service.EquipementService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EquipementServiceImpl implements EquipementService {

    private final EquipementRepository equipementRepository;
    private final EquipementMapper equipementMapper;

    @Override
    public EquipementResponseDTO createEquipement(EquipementRequestDTO equipementRequestDTO) {
        Equipement equipement = equipementMapper.toEntity(equipementRequestDTO);
        Equipement savedEquipement = equipementRepository.save(equipement);
        return equipementMapper.toResponseDTO(savedEquipement);
    }

    @Override
    public EquipementResponseDTO getEquipementById(Long id) {
        Equipement equipement = equipementRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Equipement introuvable avec l'id : " + id
                        )
                );

        return equipementMapper.toResponseDTO(equipement);
    }

    @Override
    public List<EquipementResponseDTO> getAllEquipements() {
        List<Equipement> equipements = equipementRepository.findAll();
        return equipements.stream()
                .map(equipementMapper::toResponseDTO)
                .toList();
    }

    @Override
    public EquipementResponseDTO patchEquipement(Long id, EquipementPatchDTO equipementPatchDTO) {

        Equipement equipement = equipementRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Equipement introuvable avec l'id : " + id
                        )
                );

        equipementMapper.updateEquipementFromPatchDTO(equipementPatchDTO, equipement);

        Equipement updatedEquipement = equipementRepository.save(equipement);
        return equipementMapper.toResponseDTO(updatedEquipement);
    }

    @Override
    public void deleteEquipement(Long id) {
        Equipement equipement = equipementRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Equipement introuvable avec l'id : " + id
                        )
                );

        equipementRepository.delete(equipement);
    }
}
