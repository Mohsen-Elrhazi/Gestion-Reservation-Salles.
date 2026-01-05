package com.app.gestionreservationssalles.controller;

import com.app.gestionreservationssalles.dto.request.SalleRequestDTO;
import com.app.gestionreservationssalles.dto.response.ApiResponse;
import com.app.gestionreservationssalles.dto.response.SalleResponseDTO;
import com.app.gestionreservationssalles.service.SalleService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping
    public ResponseEntity<ApiResponse<List<SalleResponseDTO>>> getAllSalles() {
        List<SalleResponseDTO> salles = salleService.getAllSalles();

        return ResponseEntity.ok(
                ApiResponse.<List<SalleResponseDTO>>builder()
                        .status("success")
                        .message("Salles retrieved successfully")
                        .data(salles)
                        .build()
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteSalle(@PathVariable Long id) {
        salleService.deleteSalle(id);
        return ResponseEntity.ok(
                ApiResponse.<Void>builder()
                        .status("success")
                        .message("Salle deleted successfully")
                        .data(null)
                        .build()
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<SalleResponseDTO>> updateSalle(@PathVariable Long id, @Valid @RequestBody SalleRequestDTO salleRequestDTO) {
        SalleResponseDTO updatedSalle = salleService.updateSalle(id, salleRequestDTO);
        return ResponseEntity.ok(
                ApiResponse.<SalleResponseDTO>builder()
                        .status("success")
                        .message("Salle updated successfully")
                        .data(updatedSalle)
                        .build()
        );
    }



}
