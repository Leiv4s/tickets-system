package com.suspiciousguys.tickets_system.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
@Table(name = "campo")
public class CampoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 255)
    private String campo;

    @Column(nullable = false, length = 255)
    private String descricaoCampo;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "modalidade_id", nullable = false)
    private ModalidadeModel modalidade;

    @OneToMany(mappedBy = "resposta", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<RespostaCampoModel> respostas = new HashSet<>();



}
