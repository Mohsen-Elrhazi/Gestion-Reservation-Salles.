package com.app.gestionreservationssalles.service.impl;

import com.app.gestionreservationssalles.dto.request.ReservationRequestDTO;
import com.app.gestionreservationssalles.dto.response.ReservationResponseDTO;
import com.app.gestionreservationssalles.entity.Equipement;
import com.app.gestionreservationssalles.entity.Reservation;
import com.app.gestionreservationssalles.entity.Salle;
import com.app.gestionreservationssalles.entity.User;
import com.app.gestionreservationssalles.exception.ResourceNotFoundException;
import com.app.gestionreservationssalles.mapper.ReservationMapper;
import com.app.gestionreservationssalles.repository.EquipementRepository;
import com.app.gestionreservationssalles.repository.ReservationRepository;
import com.app.gestionreservationssalles.repository.SalleRepository;
import com.app.gestionreservationssalles.repository.UserRepository;
import com.app.gestionreservationssalles.service.ReservationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class ReservationServiceImpl implements ReservationService {
    private final SalleRepository salleRepository;
    private final UserRepository userRepository;
    private final EquipementRepository equipementRepository;
    private final ReservationRepository reservationRepository;
    private final ReservationMapper reservationMapper;

    @Override
    public ReservationResponseDTO createReservation(ReservationRequestDTO dto) {
        Salle salle= salleRepository.findById(dto.getSalleId())
                .orElseThrow(()-> new ResourceNotFoundException("Salle not found with id"+ dto.getSalleId()));

        User user= userRepository.findById(dto.getUserId())
                .orElseThrow(()-> new ResourceNotFoundException("user not found with id: " + dto.getUserId()));

        List<Equipement> equipements= equipementRepository.findAllById(dto.getEquipementIds());

        Reservation reservation= new Reservation();
        reservation.setDate(dto.getDate());
        reservation.setDuree(dto.getDuree());
        reservation.setDescription(dto.getDescription());
        reservation.setUser(user);
        reservation.setSalle(salle);
        reservation.setEquipements(equipements);

        Reservation savedReservation= reservationRepository.save(reservation);
        return reservationMapper.toResponseDTO(savedReservation);
    }

    @Override
    public ReservationResponseDTO getReservationById(Long id) {
       Reservation reservation= reservationRepository.findById(id)
               .orElseThrow(()-> new ResourceNotFoundException("Reservation not found with id: "+ id));
       return reservationMapper.toResponseDTO(reservation);
    }

    @Override
    public List<ReservationResponseDTO> getMyReservations(Long userId) {
        return List.of();
    }

    @Override
    public List<ReservationResponseDTO> getAllReservations() {
        return List.of();
    }

    @Override
    public ReservationResponseDTO cancelReservation(Long id) {
        return null;
    }

    @Override
    public ReservationResponseDTO validateReservation(Long id) {
        return null;
    }

    @Override
    public ReservationResponseDTO rejectReservation(Long id) {
        return null;
    }
}
