package com.suspiciousguys.tickets_system.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "ModalidadeCampo")
public class ModalidadeCampo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "idmodalidade", nullable = false)
    private Modalidade modalidade;

    @ManyToOne
    @JoinColumn(name = "idcampo", nullable = false)
    private Campo campo;
}
