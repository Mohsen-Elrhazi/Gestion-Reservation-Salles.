package com.app.gestionreservationssalles.service;

import com.app.gestionreservationssalles.dto.request.UserRequestDTO;
import com.app.gestionreservationssalles.dto.request.UserUpdateDTO;
import com.app.gestionreservationssalles.dto.response.UserResponseDTO;

import java.util.List;

public interface UserService {
    UserResponseDTO createUser(UserRequestDTO dto);
    UserResponseDTO updateUser(Long id, UserUpdateDTO dto);

    // Activer / Désactiver
    UserResponseDTO basculerStatut(Long id);

    UserResponseDTO getUserById(Long id);
    List<UserResponseDTO> getAllUsers();
}
