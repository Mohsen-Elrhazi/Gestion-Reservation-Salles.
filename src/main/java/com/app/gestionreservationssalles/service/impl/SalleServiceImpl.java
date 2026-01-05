package com.app.gestionreservationssalles.service.impl;

import com.app.gestionreservationssalles.dto.request.SalleRequestDTO;
import com.app.gestionreservationssalles.dto.response.SalleResponseDTO;
import com.app.gestionreservationssalles.entity.Salle;
import com.app.gestionreservationssalles.exception.ResourceNotFoundException;
import com.app.gestionreservationssalles.exception.SalleNotFoundException;
import com.app.gestionreservationssalles.mapper.SalleMapper;
import com.app.gestionreservationssalles.repository.SalleRepository;
import com.app.gestionreservationssalles.service.SalleService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


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

    @Override
    public SalleResponseDTO getSalleById(Long id) {
        Salle salle= salleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Salle not found with id: " + id));

        return salleMapper.toResponseDTO(salle);
    }

    @Override
    public List<SalleResponseDTO> getAllSalles() {
        List<Salle> salles = salleRepository.findAll();
        return salles.stream()
                .map(salleMapper::toResponseDTO)
                .toList();
    }

    @Override
    public SalleResponseDTO updateSalle(Long id, SalleRequestDTO salleRequestDTO) {
        Salle salle = salleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Salle not found with id: " + id));

        salle.setNumero(salleRequestDTO.getNumero());
        salle.setNom(salleRequestDTO.getNom());
        salle.setCapacite(salleRequestDTO.getCapacite());
        salle.setType(salleRequestDTO.getType());

        Salle updatedSalle = salleRepository.save(salle);
        return salleMapper.toResponseDTO(updatedSalle);
    }

    @Override
    public void deleteSalle(Long id) {
      Salle salle= salleRepository.findById(id)
                .orElseThrow(() -> new SalleNotFoundException("Salle not found with id: " + id));

        salleRepository.delete(salle);
    }
}
