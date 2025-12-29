package com.app.gestionreservationssalles.entity;

import com.app.gestionreservationssalles.enums.TypeSalle;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SalleConference {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String numero;

    private String nom;

    private int capacite;

    @Enumerated(EnumType.STRING)
    private TypeSalle type;

    @OneToMany(mappedBy="salleConference")
    private List<Reservation> reservations;

}
