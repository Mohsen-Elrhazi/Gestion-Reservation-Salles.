package com.app.gestionreservationssalles.service.impl;

import com.app.gestionreservationssalles.dto.request.UserRequestDTO;
import com.app.gestionreservationssalles.dto.request.UserUpdateDTO;
import com.app.gestionreservationssalles.dto.response.UserResponseDTO;
import com.app.gestionreservationssalles.entity.User;
import com.app.gestionreservationssalles.enums.Role;
import com.app.gestionreservationssalles.exception.ResourceNotFoundException;
import com.app.gestionreservationssalles.mapper.UserMapper;
import com.app.gestionreservationssalles.repository.UserRepository;
import com.app.gestionreservationssalles.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
//    private final PasswordEncoder passwordEncoder;

    @Override
    public UserResponseDTO register(UserRequestDTO dto) {
       User user = userMapper.toEntity(dto);

       user.setNom(dto.getNom());
       user.setEmail(dto.getEmail());
       user.setRole(Role.EMPLOYE);
//       user.setMotDePasse(passwordEncoder.encode(dto.getMotDePasse()));
       user.setRole(Role.EMPLOYE);

         User savedUser = userRepository.save(user);
       return userMapper.toResponseDTO(savedUser);
    }

    @Override
    public UserResponseDTO updateUser(Long id, UserUpdateDTO dto) {
       User user= userRepository.findById(id)
               .orElseThrow(()-> new ResourceNotFoundException("User not found with id: "+id));

       if(dto.getNom() != null){
         user.setNom(dto.getNom());
       }
       if(dto.getEmail() != null){
            user.setEmail(dto.getEmail());
       }
       if(dto.getMotDePasse() != null){
//           user.setMotDePasse(passwordEncoder.encode(dto.getMotDePasse()));

       }

        User updatedUser = userRepository.save(user);
        return userMapper.toResponseDTO(updatedUser);
    }

    @Override
    public UserResponseDTO basculerStatut(Long id) {
        User user= userRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("User not found with id: "+id));

        user.setActif(!user.getActif());
        User updatedUser = userRepository.save(user);
        return userMapper.toResponseDTO(updatedUser);
    }

    @Override
    public UserResponseDTO getUserById(Long id) {
        User user= userRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("User not found with id: "+id));
        return userMapper.toResponseDTO(user);
    }

    @Override
    public List<UserResponseDTO> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream()
                .map(userMapper::toResponseDTO)
                .toList();
    }
}
