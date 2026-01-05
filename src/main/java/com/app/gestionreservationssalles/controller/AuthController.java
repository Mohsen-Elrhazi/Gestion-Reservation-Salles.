package com.app.gestionreservationssalles.controller;

import com.app.gestionreservationssalles.dto.request.UserRequestDTO;
import com.app.gestionreservationssalles.dto.response.ApiResponse;
import com.app.gestionreservationssalles.dto.response.UserResponseDTO;
import com.app.gestionreservationssalles.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@AllArgsConstructor
public class AuthController {
    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<ApiResponse<UserResponseDTO>> regiter(@RequestBody UserRequestDTO dto){
        UserResponseDTO userResponseDTO = userService.register(dto);

        return ResponseEntity.ok(
                ApiResponse.<UserResponseDTO>builder()
                        .status("success")
                        .message("User registred successfully")
                        .data(userResponseDTO)
                        .build()
        );
    }

}
