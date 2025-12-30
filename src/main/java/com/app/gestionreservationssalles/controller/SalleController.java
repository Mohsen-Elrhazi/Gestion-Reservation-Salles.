package com.app.gestionreservationssalles.controller;

import com.app.gestionreservationssalles.dto.request.SalleRequestDTO;
import com.app.gestionreservationssalles.dto.response.ApiResponse;
import com.app.gestionreservationssalles.dto.response.SalleResponseDTO;
import com.app.gestionreservationssalles.service.SalleService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/salles")
@AllArgsConstructor
public class SalleController {
    private final SalleService salleService;

    @PostMapping
    public ResponseEntity<ApiResponse<SalleResponseDTO>> createSalle(@Valid @RequestBody SalleRequestDTO salleRequestDTO) {
        SalleResponseDTO salleResponseDTO = salleService.createSalle(salleRequestDTO);
        return ResponseEntity.ok(
            ApiResponse.<SalleResponseDTO>builder()
                .status("success")
                .message("Salle created successfully")
                .data(salleResponseDTO)
                .build()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<SalleResponseDTO>> getSalleById(@PathVariable Long id) {
        SalleResponseDTO salleResponseDTO = salleService.getSalleById(id);
        return ResponseEntity.ok(
                ApiResponse.<SalleResponseDTO>builder()
                        .status("success")
                        .message("Salle retrieved successfully")
                        .data(salleResponseDTO)
                        .build()
        );
    }


}
