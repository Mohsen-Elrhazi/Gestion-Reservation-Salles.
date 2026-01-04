package com.app.gestionreservationssalles.controller;

import com.app.gestionreservationssalles.dto.request.ReservationRequestDTO;
import com.app.gestionreservationssalles.dto.response.ApiResponse;
import com.app.gestionreservationssalles.dto.response.ReservationResponseDTO;
import com.app.gestionreservationssalles.entity.Reservation;
import com.app.gestionreservationssalles.service.ReservationService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/reservations")
@AllArgsConstructor
public class ReservationController {
    private final ReservationService reservationService;

    @PostMapping
    public ResponseEntity<ApiResponse<ReservationResponseDTO>> createReservation(@RequestBody ReservationRequestDTO dto){
        ReservationResponseDTO reservationResponseDTO= reservationService.createReservation((dto));

        return ResponseEntity.ok(
                ApiResponse.<ReservationResponseDTO>builder()
                        .status("success")
                        .message("Reservation created successfully")
                        .data(reservationResponseDTO)
                        .build()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<ReservationResponseDTO>> getReservationById(@PathVariable long id){
        ReservationResponseDTO reservationResponseDTO= reservationService.getReservationById(id);

        return ResponseEntity.ok(
                ApiResponse.<ReservationResponseDTO>builder()
                        .status("success")
                        .message("Reservation retrieved successfully")
                        .data(reservationResponseDTO)
                        .build()
        );
    }
}
