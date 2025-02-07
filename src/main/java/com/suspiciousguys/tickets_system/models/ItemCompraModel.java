package com.suspiciousguys.tickets_system.models;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Entity
@Table(name = "itemCompra")
public class ItemCompraModel {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private Integer quantidade;
    private BigDecimal precoUnitario;

    @ManyToOne
    @JoinColumn(name = "compra_id", nullable = false)
    private CompraModel compraModel;

    @ManyToOne
    @JoinColumn(name = "ingresso_id",nullable = false)
    private IngressoModel ingressoModel;


}
