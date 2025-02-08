package com.suspiciousguys.tickets_system.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
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

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToMany
    @JoinTable(name = "eventoOrganizador",
            joinColumns = @JoinColumn(name = "organizador_id"),
            inverseJoinColumns = @JoinColumn (name = "evento_id")
    )
    private Set<OrganizadorModel> organizadores = new HashSet<>();

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToMany
    @NotEmpty
    @JoinTable(name = "eventoDataEvento",
                joinColumns = @JoinColumn(name = "datasEvento_id"),
                inverseJoinColumns = @JoinColumn(name = "evento_id"))
    private Set<DatasEventoModel> datasEvento = new HashSet<>();

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "evento", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<IngressoModel> ingressos = new HashSet<>();

}
