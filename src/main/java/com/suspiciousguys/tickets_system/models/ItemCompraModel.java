package com.suspiciousguys.tickets_system.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.suspiciousguys.tickets_system.dtos.ItemCompraDTO;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@NoArgsConstructor
@Data
@Entity
@Table(name = "itemCompra")
public class ItemCompraModel {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private BigDecimal precoUnitario;
    private Integer quantidade;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToOne
    @JoinColumn(name = "compra_id", nullable = false)
    private CompraModel compra;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToOne
    @JoinColumn(name = "ingresso_id",nullable = false)
    private IngressoModel ingresso;

    ItemCompraModel(ItemCompraDTO itemCompraDTO) {
        this.id = itemCompraDTO.getId();
        this.quantidade = itemCompraDTO.getQuantidade();
        this.precoUnitario = itemCompraDTO.getPrecoUnitario();
        this.compra = compra != null? compra: new CompraModel();
    }

}
