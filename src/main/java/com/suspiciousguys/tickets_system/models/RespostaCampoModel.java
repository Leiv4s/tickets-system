package com.suspiciousguys.tickets_system.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "respostaCampo")
public class RespostaCampoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String resposta;

    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL, optional = false)
    private CampoModel campoModel;

    @ManyToOne(fetch = FetchType.EAGER , cascade = CascadeType.ALL, optional = false)
    private IngressoModel ingressoModel;






}
