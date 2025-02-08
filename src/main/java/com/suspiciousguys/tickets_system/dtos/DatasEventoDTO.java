package com.suspiciousguys.tickets_system.dtos;

import jakarta.persistence.Column;
import jakarta.persistence.GenerationType;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@Data
public class DatasEventoDTO {

    private Long id;
    private LocalDate data;

}
