package com.app.gestionreservationssalles.repository;

import com.app.gestionreservationssalles.entity.Salle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalleRepository extends JpaRepository<Salle, Long> {
}
