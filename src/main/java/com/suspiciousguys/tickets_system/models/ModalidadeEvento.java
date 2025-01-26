package com.suspiciousguys.tickets_system.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "modalidadeEvento")
public class ModalidadeEvento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "idmodalidade", nullable = false)
    private Modalidade modalidade;

    @ManyToOne
    @JoinColumn(name = "idevento", nullable = false)
    private Evento evento;
}
