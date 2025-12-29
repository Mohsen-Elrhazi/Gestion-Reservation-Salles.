package com.app.gestionreservationssalles.service.impl;

import com.app.gestionreservationssalles.dto.request.SalleRequestDTO;
import com.app.gestionreservationssalles.dto.response.SalleResponseDTO;
import com.app.gestionreservationssalles.entity.Salle;
import com.app.gestionreservationssalles.mapper.SalleMapper;
import com.app.gestionreservationssalles.repository.SalleRepository;
import com.app.gestionreservationssalles.service.SalleService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class SalleServiceImpl implements SalleService {
    private final SalleRepository salleRepository;
    private final SalleMapper salleMapper;

    @Override
    public SalleResponseDTO createSalle(SalleRequestDTO salleRequestDTO) {
        Salle salle = salleMapper.toEntity(salleRequestDTO);
        Salle savedSalle = salleRepository.save(salle);
        return salleMapper.toResponseDTO(savedSalle);
    }
}
