package com.app.gestionreservationssalles.service;

import com.app.gestionreservationssalles.dto.request.SalleRequestDTO;
import com.app.gestionreservationssalles.dto.response.SalleResponseDTO;

import java.util.List;

public interface SalleService {
    SalleResponseDTO createSalle(SalleRequestDTO salleRequestDTO);
    SalleResponseDTO getSalleById(Long id);
    List<SalleResponseDTO> getAllSalles();
    SalleResponseDTO updateSalle(Long id, SalleRequestDTO salleRequestDTO);
    void deleteSalle(Long id);
}
