package com.app.gestionreservationssalles.entity;

import com.app.gestionreservationssalles.enums.StatutReservation;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private LocalDateTime date;

    private int duree;

    private String description;

    @Enumerated(EnumType.STRING)
    private StatutReservation statut;
}
