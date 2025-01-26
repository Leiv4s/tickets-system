package com.suspiciousguys.tickets_system.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "eventoOrganizador")
public class EventoOrganizador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_organizador", nullable = false)
    private Organizador organizador;

    @ManyToOne
    @JoinColumn(name = "idevento", nullable = false)
    private Evento evento;
}
