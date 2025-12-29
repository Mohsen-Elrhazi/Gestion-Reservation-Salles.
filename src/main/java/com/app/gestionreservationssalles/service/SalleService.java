package com.app.gestionreservationssalles.service;

import com.app.gestionreservationssalles.dto.request.SalleRequestDTO;
import com.app.gestionreservationssalles.dto.response.SalleResponseDTO;

public interface SalleService {
    SalleResponseDTO createSalle(SalleRequestDTO salleRequestDTO);

}
