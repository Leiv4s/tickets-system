package com.suspiciousguys.tickets_system.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
@Table(name = "ingressos")
public class IngressoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 255)
    private String descricao;

    @Column(nullable = false)
    private Integer dias;

    @ManyToOne
    @JoinColumn(name = "cliente")
    private ClienteModel cliente;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "evento_id", nullable = false)
    private EventoModel evento;

    @OneToMany(mappedBy = "ingresso", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<ModalidadeModel> modalidades = new HashSet<>();

    @OneToMany(mappedBy = "ingressoModel", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<RespostaCampoModel> respostaCampo = new HashSet<>();

}

