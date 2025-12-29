package com.app.gestionreservationssalles.controller;

import com.app.gestionreservationssalles.service.SalleService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/salles")
@AllArgsConstructor
public class SalleController {
    private final SalleService salleService;


}
