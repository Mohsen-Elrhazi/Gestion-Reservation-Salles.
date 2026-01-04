package com.app.gestionreservationssalles.service;

import com.app.gestionreservationssalles.dto.request.ReservationRequestDTO;
import com.app.gestionreservationssalles.dto.response.ReservationResponseDTO;

import java.util.List;

public interface ReservationService {
    ReservationResponseDTO createReservation(ReservationRequestDTO dto);

    ReservationResponseDTO getReservationById(Long id);

    List<ReservationResponseDTO> getMyReservations(Long userId);

    List<ReservationResponseDTO> getAllReservations();

    ReservationResponseDTO cancelReservation(Long id);

    ReservationResponseDTO validateReservation(Long id);

    ReservationResponseDTO rejectReservation(Long id);
}
