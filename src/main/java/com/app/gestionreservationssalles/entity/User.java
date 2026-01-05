package com.app.gestionreservationssalles.entity;

import com.app.gestionreservationssalles.enums.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nom;

    private String email;

    private String motDePasse;

    @Enumerated(EnumType.STRING)
    private Role role = Role.EMPLOYE;

    private Boolean actif= true;

    @OneToMany(mappedBy="user")
    private List<Reservation> reservations;
}
