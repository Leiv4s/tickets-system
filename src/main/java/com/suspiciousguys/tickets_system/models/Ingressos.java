package com.suspiciousguys.tickets_system.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "ingressos")
public class Ingressos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 255)
    private String descricao;

    @Column(nullable = false)
    private Integer dias;

    @ManyToOne
    @JoinColumn(name = "idcliente", nullable = false)
    private Cliente cliente;
}
