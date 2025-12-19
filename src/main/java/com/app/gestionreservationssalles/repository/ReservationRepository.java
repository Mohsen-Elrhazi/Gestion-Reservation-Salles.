package com.app.gestionreservationssalles.repository;

import com.app.gestionreservationssalles.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
}
