package com.app.gestionreservationssalles.mapper;

import com.app.gestionreservationssalles.dto.request.EquipementPatchDTO;
import com.app.gestionreservationssalles.dto.request.EquipementRequestDTO;
import com.app.gestionreservationssalles.dto.response.EquipementResponseDTO;
import com.app.gestionreservationssalles.entity.Equipement;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface EquipementMapper {
    Equipement toEntity(EquipementRequestDTO dto);

    EquipementResponseDTO toResponseDTO(Equipement entity);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEquipementFromPatchDTO(EquipementPatchDTO dto, @MappingTarget Equipement entity);
}
