package com.app.gestionreservationssalles.mapper;

import com.app.gestionreservationssalles.dto.request.ReservationRequestDTO;
import com.app.gestionreservationssalles.dto.response.ReservationResponseDTO;
import com.app.gestionreservationssalles.entity.Reservation;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ReservationMapper {
    Reservation toEntity(ReservationRequestDTO dto);

    @Mapping(target = "salleNom", source = "salle.nom")
    @Mapping(target = "userNom", source = "user.nom")
//    @Mapping(target = "equipements", source = "equipements")
    ReservationResponseDTO toResponseDTO(Reservation entity);
}
