package com.suspiciousguys.tickets_system.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "respostaCampo")
public class RespostaCampo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String conteudo;

    @ManyToOne
    @JoinColumn(name = "idcampo", nullable = false)
    private Campo campo;

    @ManyToOne
    @JoinColumn(name = "idingressos", nullable = false)
    private Ingressos ingresso;
}
