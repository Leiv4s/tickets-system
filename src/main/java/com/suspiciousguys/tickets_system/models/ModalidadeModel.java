package com.suspiciousguys.tickets_system.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
@Table(name = "modalidade")
public class ModalidadeModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private int ingressosDisponiveis;

    @Column(nullable = false)
    private BigDecimal preco;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToOne()
    @JoinColumn(name = "ingresso_id", nullable = false)
    private IngressoModel ingresso;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "campo", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<CampoModel> campos = new HashSet<>();
}
