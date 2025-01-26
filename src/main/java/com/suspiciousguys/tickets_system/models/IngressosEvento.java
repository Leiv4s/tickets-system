package com.suspiciousguys.tickets_system.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "ingressosEvento")
public class IngressosEvento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "idevento", nullable = false)
    private Evento evento;

    @ManyToOne
    @JoinColumn(name = "idingressos", nullable = false)
    private Ingressos ingresso;
}
