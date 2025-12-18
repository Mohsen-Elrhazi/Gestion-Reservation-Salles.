package com.app.gestionreservationssalles.repository;

import com.app.gestionreservationssalles.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
