package com.app.gestionreservationssalles.entity;

import com.app.gestionreservationssalles.enums.TypeEquipement;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Equipement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nom;

    private double poids;

    @Enumerated(EnumType.STRING)
    private TypeEquipement type;

    @ManyToMany(mappedBy = "equipements")
    private List<Reservation> reservations;
}
