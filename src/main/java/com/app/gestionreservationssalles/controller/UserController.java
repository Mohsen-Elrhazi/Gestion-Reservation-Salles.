package com.app.gestionreservationssalles.controller;

import com.app.gestionreservationssalles.dto.request.UserRequestDTO;
import com.app.gestionreservationssalles.dto.request.UserUpdateDTO;
import com.app.gestionreservationssalles.dto.response.ApiResponse;
import com.app.gestionreservationssalles.dto.response.UserResponseDTO;
import com.app.gestionreservationssalles.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@AllArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping
    public ResponseEntity<ApiResponse<UserResponseDTO>> createUser(@RequestBody UserRequestDTO dto){
        UserResponseDTO userResponseDTO = userService.createUser(dto);

        return ResponseEntity.ok(
                ApiResponse.<UserResponseDTO>builder()
                        .status("success")
                        .message("User created successfully")
                        .data(userResponseDTO)
                        .build()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<UserResponseDTO>> getUserById(@PathVariable Long id){
        UserResponseDTO userResponseDTO = userService.getUserById(id);

        return ResponseEntity.ok(
                ApiResponse.<UserResponseDTO>builder()
                        .status("success")
                        .message("User retrieved successfully")
                        .data(userResponseDTO)
                        .build()
        );
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<UserResponseDTO>>> getAllUsers(){
        List<UserResponseDTO> users = userService.getAllUsers();

        return ResponseEntity.ok(
                ApiResponse.<java.util.List<UserResponseDTO>>builder()
                        .status("success")
                        .message("Users retrieved successfully")
                        .data(users)
                        .build()
        );
    }

    @PutMapping("/toggle-status/{id}")
    public ResponseEntity<ApiResponse<UserResponseDTO>> basculerStatut(@PathVariable Long id){
        UserResponseDTO userResponseDTO= userService.basculerStatut(id);

        return ResponseEntity.ok(
                ApiResponse.<UserResponseDTO>builder()
                        .status("success")
                        .message("User status toggled successfully")
                        .data(userResponseDTO)
                        .build()
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<UserResponseDTO>> updateUser(@PathVariable Long id, @RequestBody UserUpdateDTO dto) {
        UserResponseDTO userResponseDTO = userService.updateUser(id, dto);

        return ResponseEntity.ok(
                ApiResponse.<UserResponseDTO>builder()
                        .status("success")
                        .message("User updated successfully")
                        .data(userResponseDTO)
                        .build()
        );
    }

}
