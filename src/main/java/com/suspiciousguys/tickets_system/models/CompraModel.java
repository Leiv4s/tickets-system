package com.suspiciousguys.tickets_system.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.suspiciousguys.tickets_system.dtos.CompraDTO;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
@Table(name = "compra")
public class CompraModel {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private LocalDateTime dataCompra;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private ClienteModel cliente;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "compra")
    private Set<ItemCompraModel> itens = new HashSet<>();


    CompraModel(CompraDTO compraDTO) {
        this.id = compraDTO.getId();
        this.dataCompra = compraDTO.getDataCompra();
        this.cliente = (cliente != null) ? cliente : null;
        this.itens = (itens != null) ? itens : new HashSet<>();

    }

}
