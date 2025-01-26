package com.suspiciousguys.tickets_system.models;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Entity
@Table(name="EventoDataEvento")
public class EventoDataEvento {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_evento", referencedColumnName = "id", nullable = false)
    private Evento evento;

    @ManyToOne
    @JoinColumn(name = "id_dataEvento", referencedColumnName = "id", nullable = false)
    private DatasEvento dataEvento;
}
