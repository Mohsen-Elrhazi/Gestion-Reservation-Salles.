package com.app.gestionreservationssalles.mapper;

import com.app.gestionreservationssalles.dto.request.SalleRequestDTO;
import com.app.gestionreservationssalles.dto.response.SalleResponseDTO;
import com.app.gestionreservationssalles.entity.Salle;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SalleMapper {
    Salle toEntity(SalleRequestDTO dto);

    SalleResponseDTO toResponseDTO(Salle entity);
}
