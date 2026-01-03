package com.app.gestionreservationssalles.controller;

import com.app.gestionreservationssalles.dto.request.EquipementPatchDTO;
import com.app.gestionreservationssalles.dto.request.EquipementRequestDTO;
import com.app.gestionreservationssalles.dto.response.ApiResponse;
import com.app.gestionreservationssalles.dto.response.EquipementResponseDTO;
import com.app.gestionreservationssalles.service.EquipementService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/equipements")
@AllArgsConstructor
public class EquipementController {

    private final EquipementService equipementService;

    @PostMapping
    public ResponseEntity<ApiResponse<EquipementResponseDTO>> createEquipement( @RequestBody EquipementRequestDTO equipementRequestDTO) {

        EquipementResponseDTO equipementResponseDTO = equipementService.createEquipement(equipementRequestDTO);

        return ResponseEntity.ok(
                ApiResponse.<EquipementResponseDTO>builder()
                        .status("success")
                        .message("Equipement created successfully")
                        .data(equipementResponseDTO)
                        .build()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<EquipementResponseDTO>> getEquipementById( @PathVariable Long id) {

        EquipementResponseDTO equipementResponseDTO = equipementService.getEquipementById(id);

        return ResponseEntity.ok(
                ApiResponse.<EquipementResponseDTO>builder()
                        .status("success")
                        .message("Equipement retrieved successfully")
                        .data(equipementResponseDTO)
                        .build()
        );
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<EquipementResponseDTO>>> getAllEquipements() {

        List<EquipementResponseDTO> equipements = equipementService.getAllEquipements();

        return ResponseEntity.ok(
                ApiResponse.<List<EquipementResponseDTO>>builder()
                        .status("success")
                        .message("Equipements retrieved successfully")
                        .data(equipements)
                        .build()
        );
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ApiResponse<EquipementResponseDTO>> patchEquipement(@PathVariable Long id, @RequestBody EquipementPatchDTO equipementPatchDTO) {

        EquipementResponseDTO updatedEquipement = equipementService.patchEquipement(id, equipementPatchDTO);

        return ResponseEntity.ok(
                ApiResponse.<EquipementResponseDTO>builder()
                        .status("success")
                        .message("Equipement updated successfully")
                        .data(updatedEquipement)
                        .build()
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteEquipement(@PathVariable Long id) {

        equipementService.deleteEquipement(id);

        return ResponseEntity.ok(
                ApiResponse.<Void>builder()
                        .status("success")
                        .message("Equipement deleted successfully")
                        .data(null)
                        .build()
        );
    }
}
