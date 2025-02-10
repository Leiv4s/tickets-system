package com.suspiciousguys.tickets_system.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.suspiciousguys.tickets_system.dtos.EventoDTO;
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
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(nullable = false, length = 255)
    private String nome;

    @Column(length = 255)
    private String descricao;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm:ss")
    @Column(nullable = false)
    private LocalTime horario;

    @Column(nullable = false, length = 255)
    private String local;

    @Column(nullable = false)
    private Long capacidade_max;



    public EventoModel(EventoDTO eventoDTO) {
        this.nome = eventoDTO.getNome();
        this.descricao = eventoDTO.getDescricao();
        this.horario = eventoDTO.getHorario();
        this.local = eventoDTO.getLocal();
        this.capacidade_max = eventoDTO.getCapacidade_max();
    }

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToMany
    @JoinTable(name = "eventoOrganizador",
            joinColumns = @JoinColumn(name = "organizador_id"),
            inverseJoinColumns = @JoinColumn (name = "evento_id")
    )
    private Set<OrganizadorModel> organizadores = new HashSet<>();

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToMany
    @JoinTable(name = "eventoDataEvento",
                joinColumns = @JoinColumn(name = "datasEvento_id"),
                inverseJoinColumns = @JoinColumn(name = "evento_id"))
    private Set<DatasEventoModel> datasEvento = new HashSet<>();

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "evento", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private Set<IngressoModel> ingressos = new HashSet<>();

    @Override
    public String toString() {
        return "EventoModel{" +
                "datasEvento=" + datasEvento +
                ", ingressos=" + ingressos +
                ", organizadores=" + organizadores +
                ", capacidade_max=" + capacidade_max +
                ", local='" + local + '\'' +
                ", horario=" + horario +
                ", descricao='" + descricao + '\'' +
                ", nome='" + nome + '\'' +
                ", id=" + id +
                '}';
    }
}
