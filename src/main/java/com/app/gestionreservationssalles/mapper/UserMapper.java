package com.app.gestionreservationssalles.mapper;

import com.app.gestionreservationssalles.dto.request.UserRequestDTO;
import com.app.gestionreservationssalles.dto.response.UserResponseDTO;
import com.app.gestionreservationssalles.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toEntity(UserRequestDTO dto);

    UserResponseDTO toResponseDTO(User entity);
}
