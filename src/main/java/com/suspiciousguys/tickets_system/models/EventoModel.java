package com.suspiciousguys.tickets_system.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "evento")
public class EventoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 255)
    private String nome;

    @Column(columnDefinition = "TEXT")
    private String descricao;

    @Column(nullable = false)
    private LocalDate data;

    @Column(nullable = false)
    private LocalTime horario;

    @Column(nullable = false, length = 255)
    private String local;

    @Column(nullable = false)
    private Integer capacidade_max;


    @ManyToMany
    @JoinTable(name = "eventoOrganizador",
            joinColumns = @JoinColumn(name = "organizador_id"),
            inverseJoinColumns = @JoinColumn (name = "evento_id")
    )
    private Set<OrganizadorModel> organizadores = new HashSet<>();

    @ManyToMany
    @JoinTable(name = "eventoDataEvento",
                joinColumns = @JoinColumn(name = "datasEvento_id"),
                inverseJoinColumns = @JoinColumn(name = "evento_id"))
    private Set<DatasEventoModel> datasEvento = new HashSet<>();

    @OneToMany(mappedBy = "evento", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<IngressoModel> ingressos = new HashSet<>();

}
