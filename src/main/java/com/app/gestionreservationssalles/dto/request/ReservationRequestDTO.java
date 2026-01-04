package com.app.gestionreservationssalles.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReservationRequestDTO {
    private LocalDateTime date;
    private int duree;
    private String description;

    private Long salleId;
    private Long userId;

    private List<Long> equipementIds;

}
