package com.app.gestionreservationssalles.auth.controller;

import com.app.gestionreservationssalles.auth.dto.request.LoginRequestDTO;
import com.app.gestionreservationssalles.auth.dto.request.RefreshTokenRequestDTO;
import com.app.gestionreservationssalles.auth.dto.response.AuthResponseDTO;
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

    @PostMapping("/refresh-token")
    public ResponseEntity<ApiResponse<AuthResponseDTO>> refreshToken(@RequestBody RefreshTokenRequestDTO request){
        AuthResponseDTO AuthResponseDTO = authService.refreshToken(request);

        return ResponseEntity.ok(
                ApiResponse.<AuthResponseDTO>builder()
                        .status("success")
                        .message("Token refreshed successfully")
                        .data(AuthResponseDTO)
                        .build()
        );
    }

    @PostMapping("/logout")
    public ResponseEntity<ApiResponse<Void>> logout(@RequestBody RefreshTokenRequestDTO request) {
        authService.logout(request);
        return ResponseEntity.ok(
                ApiResponse.<Void>builder()
                        .status("success")
                        .message("Logout successful")
                        .data(null)
                        .build()
        );
    }

}
