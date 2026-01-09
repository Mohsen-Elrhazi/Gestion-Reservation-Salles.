package com.app.gestionreservationssalles.auth.controller;

import com.app.gestionreservationssalles.auth.dto.*;
import com.app.gestionreservationssalles.auth.service.AuthService;
import com.app.gestionreservationssalles.dto.response.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<ApiResponse<AuthResponseDTO>> login(@RequestBody LoginRequestDTO request){
        AuthResponseDTO authResponse = authService.login(request);

        return ResponseEntity.ok(
                ApiResponse.<AuthResponseDTO>builder()
                        .status("success")
                        .message("Login successful")
                        .data(authResponse)
                        .build()
        );
    }

}
