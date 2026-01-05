package com.app.gestionreservationssalles.entity;

import com.app.gestionreservationssalles.enums.StatutReservation;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

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
    private StatutReservation statut= StatutReservation.PENDING;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name="salle_id")
    private Salle salle;

    @ManyToMany
    @JoinTable(
        name = "reservation_equipement",
        joinColumns = @JoinColumn(name = "reservation_id"),
        inverseJoinColumns = @JoinColumn(name = "equipement_id")
    )
    private List<Equipement> equipements;


}
