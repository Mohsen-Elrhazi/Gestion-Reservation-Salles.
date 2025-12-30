package com.app.gestionreservationssalles.repository;

import com.app.gestionreservationssalles.entity.Equipement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EquipementRepository extends JpaRepository<Equipement, Long> {
}
